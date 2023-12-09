package util;

import dao.AdvertisementDao;
import dao.CategoryDao;
import dao.UserDao;
import dao.UserDetailsDao;
import dto.converters.AdvertisementDtoConverter;
import service.AdvertisementService;
import service.CategoryService;
import service.UserDetailsService;
import service.UserService;
import ui.Menu;
import ui.StartMenu;

public class AppRunner {
    public static void run() {

        UserDetailsDao userDetailsDao = new UserDetailsDao();
        UserDao userDao = new UserDao();
        CategoryDao categoryDao = new CategoryDao();
        AdvertisementDao advertisementDao = new AdvertisementDao();

        // Initialize services
        UserDetailsService userDetailsService = new UserDetailsService(userDetailsDao);
        CategoryService categoryService = new CategoryService(categoryDao);
        AdvertisementDtoConverter advertisementDtoConverter = new AdvertisementDtoConverter();
        AdvertisementService advertisementService = new AdvertisementService(advertisementDao, categoryService, advertisementDtoConverter);
        UserService userService = new UserService(userDao, userDetailsService, advertisementService);

        runApplication(userService, advertisementService, categoryService);


    }

    private static void runApplication(UserService userService, AdvertisementService advertisementService, CategoryService categoryService) {
        Menu startMenu = new StartMenu(userService, advertisementService, categoryService);
        startMenu.displayMenu();
    }
}
