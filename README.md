Dokumentacja Projektowa: Przebieg gry w BATTLESHIPS
1. Przegląd Projektu
Przebieg gry w BATTLESHIPS to implementacja strategicznej gry turowej w języku Java (SE 21), łącząca mechanikę gier planszowych z elementami karcianymi (Deck Building). Aplikacja symuluje potyczki morskie na macierzy 6x6, wykorzystując zróżnicowane frakcje, typy jednostek oraz system zarządzania zasobami (ekonomia kredytów).

Projekt realizowany jest w oparciu o wzorzec architektoniczny MVC (Model-View-Controller), z wykorzystaniem biblioteki Swing do obsługi interfejsu graficznego użytkownika.

2. Specyfikacja Techniczna
Stos Technologiczny
Język: Java SE 21

GUI: Java Swing (javax.swing)

IDE: Eclipse

Kontrola Wersji: Git

Architektura Systemu (MVC)
Projekt został podzielony na trzy niezależne warstwy logiczne:

Model (src/model): Odpowiada za strukturę danych i stan gry. Zawiera definicje kart, logikę planszy oraz parametry gracza. Nie posiada zależności do warstwy widoku.

View (src/view): Odpowiada za prezentację danych. Implementuje komponenty Swing (JFrame, JPanel) renderujące stan planszy i rękę gracza.

Controller (src/controller): Pośredniczy między modelem a widokiem. Przetwarza interakcje użytkownika i zarządza przepływem gry (Game Loop, Draft System).

3. Mechanika i Logika Gry
3.1. System Doboru Floty (Draft System)
Przed rozpoczęciem rozgrywki następuje faza losowania jednostek. Każdy gracz otrzymuje flotę składającą się z 5 kart. Algorytm losujący uwzględnia ważone prawdopodobieństwo rzadkości kart:

Standard: 85% szans

Unique (Unikalna): 10% szans

Legendary (Legendarna): 5% szans

3.2. Frakcje i Balans
Gra obsługuje cztery frakcje o zróżnicowanej specyfice. Zaimplementowano unikalną logikę dla frakcji ZSRR:

GER / USA / JAP: Standardowy schemat losowania (1x Lotniskowiec, 1x Pancernik, 1x Krążownik, 1x Niszczyciel, 1x Okręt Podwodny).

ZSR (Związek Radziecki): Zmodyfikowany algorytm doboru – frakcja nie posiada lotniskowców. W zamian otrzymuje dodatkowy slot na Pancernik (2x Pancernik w puli).

3.3. Środowisko Rozgrywki
Plansza: Macierz obiektów ShipCard o wymiarach 6x6.


Ekonomia: System "Kredytów" przyznawanych co turę, wymaganych do aktywacji metod specjalnych (umiejętności) zdefiniowanych w obiektach kart.

Warunki Zwycięstwa: Całkowita eliminacja jednostek przeciwnika z macierzy planszy.

4. Struktura Projektu
Poniżej przedstawiono opis kluczowych klas i pakietów w strukturze katalogów:

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
