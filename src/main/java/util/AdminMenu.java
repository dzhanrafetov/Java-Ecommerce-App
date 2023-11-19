package util;

import java.util.Scanner;

public class AdminMenu implements Menu{
    @Override
    public void displayMenu() {
        System.out.println("This is Admin Menu");
        System.out.println("1.");
        System.out.println("2.");
    }

    @Override
    public int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    @Override
    public void performAction(int choice) {
        switch (choice){
            case 1:
                System.out.println("Dopamine");
                break;
            case 2:
                System.out.println("Melatonine");
                break;
        }


    }
}
