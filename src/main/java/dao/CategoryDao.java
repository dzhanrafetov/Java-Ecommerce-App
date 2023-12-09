package dao;


import model.Category;

import util.DatabaseUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    //----------------CREATE METHODS----START------------------------

    public Category createCategory(Category category) {
        String sql = "INSERT INTO category (name,description,createdAt,updatedAt)  values(?,?,?,?) ";

        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            LocalDateTime createdAt = category.getCreatedAt().truncatedTo(ChronoUnit.SECONDS);
            LocalDateTime updatedAt = category.getUpdatedAt().truncatedTo(ChronoUnit.SECONDS);

            statement.setTimestamp(3, Timestamp.valueOf(createdAt));
            statement.setTimestamp(4, Timestamp.valueOf(updatedAt));
            statement.executeUpdate();
            return category;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //----------------CREATE METHODS----END------------------------


    //----------------GET METHODS----START------------------------

    public List<Category> getCategories() {
        String sql = "SELECT * FROM category;";
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Category category = new Category(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                categories.add(category);
            }
            return categories;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //----------------GET METHODS----END------------------------


    //----------------DELETE METHODS----START------------------------

    public Category deleteCategory(long categoryId) {
        String sql = "DELETE FROM category WHERE id = ?;";
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, categoryId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    //----------------DELETE METHODS----END------------------------


}



