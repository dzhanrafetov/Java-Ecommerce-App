package ui;

import service.AdvertisementService;
import service.UserService;

public class UserMenu extends BaseMenu {
    private final UserService userService;
    private final AdvertisementService advertisementService;

    public UserMenu(UserService userService, AdvertisementService advertisementService) {
        this.userService = userService;
        this.advertisementService = advertisementService;
        addMenuChoice(1, "Show User Information");
        addMenuChoice(2, "Show User Advertisements");
        addMenuChoice(3, "Show Advertisements");
        addMenuChoice(4, "Create Advertisement");
        addMenuChoice(5, "Find Advertisement By Id");
        addMenuChoice(6, "Update Advertisement");
        addMenuChoice(7, "Delete Advertisement");


    }

    @Override
    protected void performAction(int choice) {
        switch (choice) {
            case 1:
                userService.getUserInformation();
                break;
            case 2:
                advertisementService.getUserAdvertisements();

                break;
            case 3:
                advertisementService.getActiveAdvertisements();
                break;

            case 4:
                advertisementService.createAdvertisement();
                break;
            case 5:
                advertisementService.getAdvertisementById();
                break;

            case 6:
                advertisementService.updateUserAdvertisement();
                break;
            case 7:
                advertisementService.deleteUserAdvertisement();
                break;
            default:
        }

    }

    @Override
    public String getMenuName() {
        return "User Menu";
    }
}
