package ui;

import model.User;
import service.AdvertisementService;
import service.CategoryService;
import service.UserService;

public class StartMenu extends BaseMenu {
    private final UserService userService;
    private final AdvertisementService advertisementService;
    private final CategoryService categoryService;

    public StartMenu(UserService userService, AdvertisementService advertisementService, CategoryService categoryService) {
        this.userService = userService;
        this.advertisementService = advertisementService;
        this.categoryService = categoryService;
        addMenuChoice(0, "Exit");
        addMenuChoice(1, "Login");
        addMenuChoice(2, "Register");

    }

    @Override
    protected void performAction(int choice) {
        switch (choice) {
            case 1:
                handleRoleSpecificActions(userService.authenticateUser());

                break;
            case 2:
                userService.createUser();
                break;
            default:
        }
    }

    @Override
    public String getMenuName() {
        return "Start Menu";
    }

    private void handleRoleSpecificActions(User user) {
        switch (user.getRole()) {
            case ADMIN_ROLE:
                AdminMenu adminMenu = new AdminMenu(userService, advertisementService, categoryService);
                adminMenu.displayMenu();
                break;
            case USER_ROLE:
                UserMenu userMenu = new UserMenu(userService, advertisementService);
                userMenu.displayMenu();
                break;
            default:
                System.out.println("Unknown role");
        }

    }
}
