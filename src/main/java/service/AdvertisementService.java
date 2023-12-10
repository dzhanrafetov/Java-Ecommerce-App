package service;

import dao.AdvertisementDao;
import dto.AdvertisementDto;
import dto.converters.AdvertisementDtoConverter;
import exception.InvalidInputException;
import exception.InvalidPriceException;
import exception.NoAvailableException;
import exception.NotFoundException;
import model.Advertisement;
import model.Category;
import util.ScannerUtil;
import util.SessionManagerUtil;
import util.TimestampUtil;

import java.math.BigDecimal;
import java.util.List;

public class AdvertisementService {
    private final AdvertisementDao advertisementDao;
    private final CategoryService categoryService;
    private final AdvertisementDtoConverter advertisementDtoConverter;


    public AdvertisementService(AdvertisementDao advertisementDao, CategoryService categoryService, AdvertisementDtoConverter advertisementDtoConverter) {
        this.advertisementDao = advertisementDao;
        this.categoryService = categoryService;
        this.advertisementDtoConverter = advertisementDtoConverter;
    }


    //----------------CREATE METHODS----START------------------------

    public void createAdvertisement() {
        String title = ScannerUtil.readString("Title:");
        String description = ScannerUtil.readString("Description:");
        BigDecimal price;

        try {
            price = ScannerUtil.readBigDecimal("Price:");

            if (price.compareTo(BigDecimal.ZERO) <= 0) {
                throw new InvalidPriceException("Price must be a positive value.");
            }
        } catch (InvalidInputException e) {
            throw new InvalidPriceException("Invalid price format. Please enter a valid positive numeric value.");
        }

        List<Category> categories = categoryService.getCategories();

        if (categories.isEmpty()) {
            throw new NoAvailableException("No available categories to choose from.");
        }

        categoryService.displayAvailableCategories(categories);
        long category_id = categoryService.selectValidCategory(categories);

        advertisementDao.createAdvertisement(
                new Advertisement(
                        TimestampUtil.getCurrentDateTime(),
                        TimestampUtil.getCurrentDateTime(),
                        title,
                        description,
                        price,
                        true,
                        SessionManagerUtil.getAuthenticatedUserId(),
                        category_id));
    }


    //----------------CREATE METHODS----END------------------------


    //----------------GET METHODS----START------------------------

    public void getActiveAdvertisements() {
        List<AdvertisementDto> advertisements = advertisementDtoConverter.convert(advertisementDao.getActiveAdvertisements());
        if (advertisements.isEmpty()) {
            throw new NoAvailableException("No available  advertisements ");

        }
        System.out.println(advertisements);
    }

    public void getAdvertisements() {
        List<AdvertisementDto> advertisements = advertisementDtoConverter.convert(advertisementDao.getAllAdvertisements());
        if (advertisements.isEmpty()) {
            throw new NoAvailableException("No available  advertisements ");

        }
        System.out.println(advertisements);
    }

    public void getUserAdvertisements() {
        List<AdvertisementDto> advertisements = advertisementDtoConverter.convert(advertisementDao.getUserAdvertisements(SessionManagerUtil.getAuthenticatedUserId()));
        if (advertisements.isEmpty()) {
            throw new NoAvailableException("No available  advertisements ");

        }
        System.out.println(advertisements);
    }

    public AdvertisementDto getAdvertisementById() {
        long advertisementId = ScannerUtil.readInt("Enter Advertisement id: ");
        Advertisement advertisement = advertisementDao.getAdvertisementById(advertisementId);

        if (advertisement == null) {
            throw new NotFoundException("Advertisement not found with ID: " + advertisementId);
        }
        System.out.println(advertisement);
        return advertisementDtoConverter.convert(advertisement);
    }

    //----------------GET METHODS----END------------------------


    //----------------DELETE METHODS----START------------------------

    public void deleteUserAdvertisement() {
        List<AdvertisementDto> advertisements = advertisementDtoConverter.convert(advertisementDao.getUserAdvertisements(SessionManagerUtil.getAuthenticatedUserId()));

        if (advertisements.isEmpty()) {
            throw new NoAvailableException("No available advertisements to choose from");

        }
        System.out.println(advertisements);
        long advertisement_id = ScannerUtil.readLong("Enter Advertisement id to delete: ");

        Advertisement advertisement=advertisementDao.getAdvertisementById(advertisement_id);

        if (advertisement == null) {
            throw new NotFoundException("Advertisement not found with  ID: " + advertisement_id);

        }
         advertisementDao.deleteUserAdvertisement(advertisement_id);

    }

    public void deleteAdvertisementById() {
        List<AdvertisementDto> advertisements = advertisementDtoConverter.convert(advertisementDao.getAllAdvertisements());
        if (advertisements.isEmpty()) {
            throw new NoAvailableException("No available advertisements to choose from.");

        }

        System.out.println(advertisements);
        long advertisement_id = ScannerUtil.readLong("Enter Advertisement id to delete: ");
        Advertisement advertisement = advertisementDao.deleteAdvertisementById(advertisement_id);

        if (advertisement == null) {
            throw new NotFoundException("Advertisement not found with ID: " + advertisement_id);

        }

    }

    public void deleteAdvertisementByUserId(long user_id) {

        advertisementDao.deleteAdvertisementByUserId(user_id);



}



    public void deleteAdvertisementByCategoryId() {

        List<Category> categories = categoryService.getCategories();

        if(categories.isEmpty()){
            throw new NoAvailableException("No available categories to choose from.");

        }
        categoryService.displayAvailableCategories(categories);

        long category_id = ScannerUtil.readLong("Enter category id");
        Advertisement advertisement = advertisementDao.deleteAdvertisementByCategoryId(category_id);
        if (advertisement == null) {
            throw new NotFoundException("Advertisement not found with  category ID: " + category_id);
        }

        categoryService.deleteCategory(category_id);

    }


    //----------------DELETE METHODS----END------------------------


    //----------------UPDATE METHODS----START------------------------

    public void updateUserAdvertisement() {
        List<AdvertisementDto> advertisements = advertisementDtoConverter.convert(advertisementDao.getUserAdvertisements(SessionManagerUtil.getAuthenticatedUserId()));
       if(advertisements.isEmpty()){
           throw new NoAvailableException("No available advertisements to choose from.");

       }
        System.out.println(advertisements);
        AdvertisementDto advertisement = getAdvertisementById();
        printUpdateOptions();

        if (advertisement == null) {
            throw new NotFoundException("Advertisement not found with  user ID: " + SessionManagerUtil.getAuthenticatedUserId());

        }
        int choice = ScannerUtil.readInt("Enter your choice: ");


        switch (choice) {
            case 1:
                advertisementDao.updateAdvertisement(advertisement.getId(), "title", ScannerUtil.readString("Enter the new Title:"));
                break;
            case 2:
                advertisementDao.updateAdvertisement(advertisement.getId(), "description", ScannerUtil.readString("Enter the new Description:"));
                break;

            case 3:
                advertisementDao.updateAdvertisement(advertisement.getId(), "price", String.valueOf(ScannerUtil.readBigDecimal("Enter the new Price:")));
                break;

            case 4:
                System.out.println(categoryService.getCategories());
                advertisementDao.updateAdvertisement(advertisement.getId(), "categoryID", String.valueOf(ScannerUtil.readLong("Enter the new Category ID:")));
                break;
        }
    }
    //------PRIVATE COMMON METHODS---START----

    private void printUpdateOptions() {
        System.out.println("What do you want to update?");
        System.out.println("1. Title");
        System.out.println("2. Description");
        System.out.println("3. Price");
        System.out.println("4. CategoryID");
    }

    //------PRIVATE COMMON METHODS---END----


    //----------------UPDATE METHODS----END------------------------


}




