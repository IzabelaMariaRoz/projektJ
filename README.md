* **IDE:** Eclipse
* **Dane:** Pliki CSV (Parsowanie strumieniowe)
* **Kontrola Wersji:** Git

### Architektura Systemu
* **Model:** Przechowuje stan gry (Plansze, Statki, Rękę Gracza). Jest całkowicie niezależny od interfejsu.
* **Controller:** Zawiera logikę biznesową – `AbilityFactory` (tłumaczenie kodów tekstowych na kod Java), `GameManager` (turowe zarządzanie grą).
* **View:** Warstwa prezentacji (obecnie logi konsolowe / szkielet Swing).

---

## 3. Mechanika i Logika Gry

### 3.1. System Danych (CSV)
Gra nie posiada "sztywno" wpisanych statystyk w kodzie. Wszystkie dane ładowane są dynamicznie przy starcie aplikacji z folderu `src/main/resources`:
* **`ships.csv`**: Baza 114 statków z parametrami HP, kosztem umiejętności i kodami efektów.
* **`actions.csv`**: Baza kart akcji (Talia), zawierająca opisy i efekty kart zagrywanych z ręki.

### 3.2. Jednostki (Ship Cards)
Każdy statek na planszy jest obiektem posiadającym:
* **Statystyki:** HP (skalowane wg rzadkości, od 5 do 24 pkt), Koszt Umiejętności.
* **Active Ability (Aktywna):** Unikalna zdolność uruchamiana przez gracza za walutę (Kredyty). Przykłady: *Strzał Snajperski, Radar, Torpeda*.
* **Passive Ability (Pasywna):** Mechanika "Reakcyjna", uruchamiana automatycznie w momencie odsłonięcia/ataku na statek. Przykłady: *Pancerz (redukcja obrażeń), Unik, Kontratak*.

### 3.3. System Walki i Kart Akcji
Gra łączy dwa systemy walki:
1.  **Umiejętności Statków:** Jednostki na planszy mogą atakować lub wspierać inne, zużywając Kredyty.
2.  **Karty Akcji (Hand):** Gracz dobiera karty z talii (`ActionDeck`). Karty te (np. *Nalot Dywanowy*, *Szybka Naprawa*) są jednorazowe i nie zużywają akcji statku.

### 3.4. System Doboru Floty (Draft)
Przed grą następuje losowanie floty (5 statków) z uwzględnieniem rzadkości:
* **Standard (85%):** Podstawowe jednostki.
* **Unique (10%):** Ulepszone statystyki i umiejętności.
* **Legendary (5%):** "Bossowie" z potężnymi pasywkami (np. Pancerz redukujący 3 obrażenia).

**Wyjątek Frakcji ZSRR:**
Zgodnie z historycznym balansem, frakcja ZSRR nie losuje Lotniskowców. W zamian otrzymuje dodatkowy slot na Pancernik, stawiając na siłę ognia artyleryjskiego.

---
Plaintext

src/
├── controller/
│   ├── DraftSystem.java     // Implementacja algorytmu losowania (RNG) i wyjątków frakcyjnych
│   └── GameManager.java     // Kontroler stanu gry i zarządzanie turami
├── model/
│   ├── enums/               // Słowniki danych: Faction, ShipType, Rarity
│   ├── Board.java           // Logika macierzy 6x6 (kolizje, rozmieszczanie)
│   ├── Card.java            // Klasa abstrakcyjna bazowa
│   ├── ShipCard.java        // Implementacja jednostki (HP, Atak, Koszt)
│   ├── CardDatabase.java    // Fabryka obiektów (Factory Pattern) mapująca nazwy statków
│   └── Player.java          // Agregator danych gracza (Ręka, Talia, Zasoby)
├── view/
│   ├── GameWindow.java      // Główny kontener aplikacji (JFrame)
│   ├── BoardPanel.java      // Komponent wizualizujący siatkę gry (GridLayout 6x6)
│   └── CardComponent.java   // Reprezentacja graficzna pojedynczej karty
└── main/
    └── Main.java            // Punkt wejścia aplikacji (inicjalizacja wątku Swing)
