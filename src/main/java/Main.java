import dao.AdvertisementDao;
import dao.CategoryDao;
import dao.UserDao;
import dao.UserDetailsDao;
import dto.converters.AdvertisementDtoConverter;
import service.AdvertisementService;
import service.CategoryService;
import service.UserDetailsService;
import service.UserService;
import ui.*;

public class Main {


    public static void main(String[] args) {

        UserDetailsDao userDetailsDao = new UserDetailsDao();
        UserDao userDao = new UserDao();


        CategoryDao categoryDao = new CategoryDao();
        CategoryService categoryService = new CategoryService(categoryDao);

        AdvertisementDao advertisementDao = new AdvertisementDao();
        AdvertisementDtoConverter advertisementDtoConverter = new AdvertisementDtoConverter();
        AdvertisementService advertisementService = new AdvertisementService(advertisementDao, categoryService, advertisementDtoConverter);
        UserDetailsService userDetailsService = new UserDetailsService(userDetailsDao);
        UserService userService = new UserService(userDao, userDetailsService, advertisementService);
        Menu menu = new StartMenu(userService, advertisementService, categoryService);
        menu.displayMenu();


//        Menu startMenu=new StartMenu(userService);
//        Scanner scan=new Scanner(System.in);
//        startMenu.displayMenu();
//        int choice =  startMenu.getUserChoice(scan);
//        startMenu.performAction(choice);


        //USER
//        UserDetailsDao userDetailsDao = new UserDetailsDao();
//        UserDao userDao = new UserDao();
//
//        // Instantiate services
//        UserDetailsService userDetailsService = new UserDetailsService(userDetailsDao);
//        UserService userService = new UserService(userDao, userDetailsService);
        //userService.createUser();
        // Create user and associated user details
//        userService.authenticateUser("shmekera", PasswordUtil.hashPassword("shmekera"));
//
//
//        System.out.println("this is id" + SessionManagerUtil.getAuthenticatedUserId());
//        System.out.println(PasswordUtil.hashPassword("dzhan"));


//USERDETAILS


//CATEGORY


    }
}
