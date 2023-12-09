package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class BaseMenu implements Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<Integer, String> menuChoices = new HashMap<>();
    private static final String MENU_HEADER = "***********************\nWelcome to %s\n***********************";
    protected int choice;

    @Override
    public void displayMenu() {
        printMenuHeader();
        printMenuOptions();

        do {
            System.out.print("Select an option: ");
            choice = getUserChoice();

            if (choice == 0) {
                System.out.println("Exiting the menu. Goodbye!");
                return;
            }

            if (!menuChoices.containsKey(choice)) {
                System.out.println("Invalid option. Please choose a valid option.");

            }

        } while (!menuChoices.containsKey(choice));

        handleUserInput();
    }

    private void printMenuHeader() {
        System.out.printf((MENU_HEADER) + "%n", getMenuName());
    }

    private void printMenuOptions() {
        System.out.println("Menu Options:");
        for (Map.Entry<Integer, String> entry : menuChoices.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.println("  ");
        System.out.println("  ");
    }

    private int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine(); // Consume the invalid input
            return getUserChoice(); // Try again
        }
    }

    protected void addMenuChoice(int option, String description) {
        menuChoices.put(option, description);
    }

    protected abstract void performAction(int choice);

    @Override
    public void handleUserInput() {
        performAction(choice);
    }
}
