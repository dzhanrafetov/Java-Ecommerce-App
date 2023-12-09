package service;

import dao.CategoryDao;
import exception.NoAvailableException;
import exception.NotFoundException;
import model.Category;
import util.ScannerUtil;
import util.SessionManagerUtil;
import util.TimestampUtil;

import java.util.List;

public class CategoryService {
    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    //----------------CREATE METHODS----START------------------------

    public void createCategory() {
        System.out.println("Enter Category details:");
        String categoryName = ScannerUtil.readString("Category Name:");
        String categoryDescription = ScannerUtil.readString("Category Description:");

        categoryDao.createCategory(new Category(
                TimestampUtil.getCurrentDateTime(),
                TimestampUtil.getCurrentDateTime(),
                categoryName,
                categoryDescription));
    }

    //----------------CREATE METHODS----END------------------------


    //----------------GET METHODS----START------------------------

    public List<Category> getCategories() {
       if(categoryDao.getCategories().isEmpty()){
           throw new NoAvailableException("No available categories ");

       }
        return categoryDao.getCategories();
    }


    //----------------GET METHODS----END------------------------


    //----------------DELETE METHODS----START------------------------

    public void deleteCategory(long categoryId) {
      Category category=  categoryDao.deleteCategory(categoryId);
      if(category == null){
          throw new NotFoundException("Category not found with  user ID: " + categoryId);

      }
    }

    //----------------DELETE METHODS----END------------------------


    //----------------OTHER METHODS----START------------------------

    public void displayAvailableCategories(List<Category> categories) {
        System.out.println("Available Categories:");
        categories.forEach(category -> System.out.println(category.getId() + ". " + category.getName()));
    }

    public long selectValidCategory(List<Category> categories) {
        long category_id;
        while (true) {
            category_id = ScannerUtil.readInt("Category id:");
            if (isValidCategory(categories, category_id)) {
                break;
            } else {
                System.out.println("Invalid Category ID. Please select a valid category.");
            }
        }
        return category_id;
    }

    public boolean isValidCategory(List<Category> categories, long categoryId) {
        for (Category category : categories) {
            if (category.getId() == categoryId) {
                return true;
            }
        }
        throw new NotFoundException("Category not found with ID: " + categoryId);
    }

    //----------------OTHER METHODS----END------------------------

}
