package model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.enums.Rarity;

public class ActionDatabase {

    private static final List<ActionCard> deck = new ArrayList<>();
    private static final Random random = new Random();

    static {
        loadActions();
    }

    private static void loadActions() {
        String filename = "actions.csv";
        try {
            // Wczytywanie pliku z resources
            InputStream is = ActionDatabase.class.getClassLoader().getResourceAsStream(filename);
            
            if (is == null) {
                System.err.println("BŁĄD: Nie znaleziono pliku actions.csv w folderze src!");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {
                if (header) { header = false; continue; }
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(";");
                // Oczekujemy formatu: id;name;rarity;action_enum;value;description
                if (data.length < 6) continue;

                try {
                    String name = data[1];
                    Rarity rarity = Rarity.valueOf(data[2]);
                    String actionEnum = data[3];
                    int value = Integer.parseInt(data[4]);
                    String desc = data[5];
    
                    ActionCard card = new ActionCard(name, rarity, actionEnum, value, desc);
                    
                    // Przypisujemy działanie używając naszej Fabryki
                    card.setEffect(AbilityFactory.createActive(actionEnum, value));
    
                    deck.add(card);
                } catch (Exception e) {
                    System.err.println("Błąd w linii actions.csv: " + line);
                }
            }
            System.out.println("Załadowano " + deck.size() + " kart akcji.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Dobiera losową kartę z talii.
     * Zmieniłem nazwę na drawCard, żeby pasowała do Main.java
     */
    public static ActionCard drawCard() {
        if (deck.isEmpty()) return null;
        
        // Proste losowanie jednej z gotowych kart
        return deck.get(random.nextInt(deck.size()));
    }
}