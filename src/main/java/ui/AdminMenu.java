package ui;

import service.AdvertisementService;
import service.CategoryService;
import service.UserService;

public class AdminMenu extends BaseMenu {
    private final UserService userService;
    private final AdvertisementService advertisementService;
    private final CategoryService categoryService;

    public AdminMenu(UserService userService, AdvertisementService advertisementService, CategoryService categoryService) {
        this.userService = userService;
        this.advertisementService = advertisementService;
        this.categoryService = categoryService;
        addMenuChoice(1, "Show Users");
        addMenuChoice(2, "Show Advertisements");
        addMenuChoice(3, "Find Advertisement By Id");
        addMenuChoice(4, "Delete User");
        addMenuChoice(5, "Delete Advertisement");
        addMenuChoice(6, "Delete Category");
        addMenuChoice(7, "Create Category");


    }

    @Override
    protected void performAction(int choice) {
        switch (choice) {
            case 1:
                userService.getUsers();
                break;
            case 2:
                advertisementService.getAdvertisements();

                break;
            case 3:
                advertisementService.getAdvertisementById();
                break;
            case 4:
                userService.deleteUser();
                break;

            case 5:
                advertisementService.deleteAdvertisementById();
                break;

            case 6:
                advertisementService.deleteAdvertisementByCategoryId();
                break;

            case 7:
                categoryService.createCategory();
                break;
            default:
        }

    }

    @Override
    public String getMenuName() {
        return "Admin Menu";
    }
}
