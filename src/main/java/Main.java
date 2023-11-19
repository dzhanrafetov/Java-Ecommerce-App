import enums.PhoneType;
import enums.UserRole;
import model.*;
import util.AdminMenu;
import util.Menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Category category = new Category(1, null, null, "Category Name", "Category Description");
        Advertisement advertisement = new Advertisement(1, null,
                null, "Title", "Desc", new BigDecimal("3.5"), true, category);
        System.out.println(advertisement);


//        PhoneNumber phoneNumber = new PhoneNumber(1, "+359", "123456789", PhoneType.MOBILE);
//
//        Address address = new Address(1, "123 Street", "City", "State", "Country", "12345");
//
//        List<Address> addresses = new ArrayList<>();
//        addresses.add(address);
//        addresses.add(address);
//        UserDetails userDetails = new UserDetails(1,
//                null,
//                null,
//                "Dzhan",
//                "Rafetov",
//                phoneNumber, addresses);
//
//        User user = new User(1,
//                "dzhan_rafetov",
//                "password",
//                UserRole.USER_ROLE,
//                userDetails);
//
//        System.out.println(user);

//
//        Menu adminMenu=new AdminMenu();
//        Scanner scan=new Scanner(System.in);
//        adminMenu.displayMenu();
//        int choice =  adminMenu.getUserChoice(scan);
//        adminMenu.performAction(choice);


    }
}
