package model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.enums.Faction;
import model.enums.Rarity;
import model.enums.ShipType;

public class CardDatabase {

    // Mapa: Klucz (np. "GER_BATTLESHIP_STANDARD") -> Lista dostępnych statków
    private static final Map<String, List<ShipCard>> database = new HashMap<>();
    private static final Random random = new Random();

    // Blok statyczny - uruchamia się raz przy starcie gry
    static {
        loadCardsFromCSV();
    }

    private static void loadCardsFromCSV() {
        String filename = "ships.csv"; 
        
        try {
            // 1. Pobieramy plik z resources (musi być w src)
            InputStream is = CardDatabase.class.getClassLoader().getResourceAsStream(filename);
            
            if (is == null) {
                System.err.println("BŁĄD KRYTYCZNY: Nie znaleziono pliku " + filename);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;
            boolean isHeader = true; 

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (line.trim().isEmpty()) continue;

                // 2. Rozbijamy linię po średniku
                String[] data = line.split(";");

                if (data.length < 13) continue; 

                // 3. Parsowanie danych
                try {
                    Faction faction = Faction.valueOf(data[1].trim());
                    ShipType type = ShipType.valueOf(data[2].trim());
                    Rarity rarity = Rarity.valueOf(data[3].trim());
                    String name = data[4].trim();
                    int hp = Integer.parseInt(data[5].trim());
                    
                    String activeName = data[6].trim();
                    int activeCost = Integer.parseInt(data[7].trim());
                    String activeEnum = data[8].trim();
                    int activeParam = Integer.parseInt(data[9].trim());
                    
                    String passiveName = data[10].trim();
                    String passiveEnum = data[11].trim();
                    int passiveParam = Integer.parseInt(data[12].trim());

                    // 4. Tworzenie obiektu ShipCard (Wzorca)
                    ShipCard newCard = new ShipCard(
                            name, faction, type, rarity, hp,
                            activeName, activeCost, activeEnum, activeParam,
                            passiveName, passiveEnum, passiveParam
                    );

                    // 5. PRZYPISANIE LOGIKI Z FABRYKI
                    newCard.setActiveAbility(AbilityFactory.createActive(activeEnum, activeParam));
                    newCard.setPassiveAbility(AbilityFactory.createPassive(passiveEnum, passiveParam));

                    // 6. Rejestracja w mapie
                    String key = generateKey(faction, type, rarity);
                    database.putIfAbsent(key, new ArrayList<>());
                    database.get(key).add(newCard);
                    
                } catch (IllegalArgumentException e) {
                    System.err.println("Błąd parsowania linii: " + line + " -> " + e.getMessage());
                }
            }
            
            System.out.println("Baza danych załadowana pomyślnie. Statki gotowe do gry.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda losująca i klonująca statek.
     */
    public static ShipCard createCard(Faction faction, ShipType type, Rarity rarity) {
        String key = generateKey(faction, type, rarity);
        List<ShipCard> templates = database.get(key);

        if (templates == null || templates.isEmpty()) {
            System.out.println("Ostrzeżenie: Brak kart w bazie dla: " + key);
            // Fallback
            return new ShipCard("Nieznany", faction, type, rarity, 10, "Brak", 0, "NONE", 0, "Brak", "NONE", 0);
        }

        // Losujemy jeden ze wzorów
        ShipCard template = templates.get(random.nextInt(templates.size()));

        // --- KLONOWANIE (POPRAWIONE - UŻYWAMY GETTERÓW) ---
        ShipCard copy = new ShipCard(
                template.getName(),
                template.getFaction(),
                template.getType(),
                template.getRarity(),
                template.getMaxHp(), 
                template.getActiveAbilityName(), 
                template.getAbilityCost(),
                template.getActiveAbilityEnum(),
                template.getActiveParams(),
                template.getPassiveAbilityName(), 
                template.getPassiveAbilityEnum(),
                template.getPassiveParams()
        );

        // --- PRZEPISANIE LOGIKI UMIEJĘTNOŚCI ---
        copy.setActiveAbility(template.getActiveAbility());
        copy.setPassiveAbility(template.getPassiveAbility());
        
        return copy;
    }

    private static String generateKey(Faction f, ShipType t, Rarity r) {
        return f.name() + "_" + t.name() + "_" + r.name();
    }
}
