package util;

import java.util.Scanner;

public interface Menu {
   void displayMenu();
   int getUserChoice(Scanner scanner);
   void performAction(int choice);

}
