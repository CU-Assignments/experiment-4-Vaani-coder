import java.util.ArrayList;
import java.util.Scanner;

public class CardCollectionSystem {
    static ArrayList<String> cards = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Card");
            System.out.println("2. Remove Card");
            System.out.println("3. Find Cards by Symbol");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    removeCard();
                    break;
                case 3:
                    findCardsBySymbol();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter card name: ");
        String card = scanner.nextLine();
        cards.add(card);
        System.out.println("Card added successfully.");
    }

    private static void removeCard() {
        System.out.print("Enter card name to remove: ");
        String card = scanner.nextLine();

        if (cards.remove(card)) {
            System.out.println("Card removed successfully.");
        } else {
            System.out.println("Card not found.");
        }
    }

    private static void findCardsBySymbol() {
        System.out.print("Enter symbol: ");
        String symbol = scanner.nextLine();

        ArrayList<String> matchingCards = new ArrayList<>();
        for (String card : cards) {
            if (card.contains(symbol)) {
                matchingCards.add(card);
            }
        }

        if (!matchingCards.isEmpty()) {
            System.out.println("Matching cards:");
            for (String card : matchingCards) {
                System.out.println(card);
            }
        } else {
            System.out.println("No cards found with the given symbol.");
        }
    }
}
