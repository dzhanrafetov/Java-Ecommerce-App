package dao;

import model.Advertisement;
import util.DatabaseUtil;
import util.TimestampUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class AdvertisementDao {

    //----------------CREATE METHODS----START------------------------
    public void createAdvertisement(Advertisement advertisement) {
        String sql = "INSERT INTO advertisement (title, description, price, isActive, createdAt, updatedAt, userID,categoryID)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, advertisement.getTitle());
            statement.setString(2, advertisement.getDescription());
            statement.setBigDecimal(3, advertisement.getPrice());
            statement.setBoolean(4, advertisement.isActive());

            LocalDateTime createdAt = advertisement.getCreatedAt().truncatedTo(ChronoUnit.SECONDS);
            LocalDateTime updatedAt = advertisement.getUpdatedAt().truncatedTo(ChronoUnit.SECONDS);

            statement.setTimestamp(5, Timestamp.valueOf(createdAt));
            statement.setTimestamp(6, Timestamp.valueOf(updatedAt));

            statement.setLong(7, advertisement.getUserId());
            statement.setLong(8, advertisement.getCategoryId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Advertisement createAdvertisementFromResultSet(ResultSet resultSet) throws SQLException {
        Timestamp createdAtTimestamp = resultSet.getTimestamp("createdAt");
        LocalDateTime createdAt = (createdAtTimestamp != null) ? createdAtTimestamp.toLocalDateTime() : null;

        Timestamp updatedAtTimestamp = resultSet.getTimestamp("updatedAt");
        LocalDateTime updatedAt = (updatedAtTimestamp != null) ? updatedAtTimestamp.toLocalDateTime() : null;

        return new Advertisement(
                resultSet.getLong("id"),
                createdAt,
                updatedAt,
                resultSet.getString("title"),
                resultSet.getString("description"),
                resultSet.getBigDecimal("price"),
                resultSet.getBoolean("isActive"),
                resultSet.getLong("userId"),
                resultSet.getLong("categoryId"));
    }

    //----------------CREATE METHODS----END------------------------



    //----------------DELETE METHODS----START------------------------

    public Advertisement deleteUserAdvertisement(long advertisement_id) {
        String sql = "DELETE FROM advertisement WHERE  id = ?;";
        return deleteAdvertisement(advertisement_id, sql);
    }
    public Advertisement deleteAdvertisementByUserId(long user_id) {
        String sql = "DELETE FROM advertisement WHERE  userID = ?;";
        return deleteAdvertisement(user_id, sql);
    }
    public Advertisement deleteAdvertisementById(long advertisement_id) {
        String sql = "DELETE FROM advertisement WHERE id = ?;";
        return deleteAdvertisement(advertisement_id, sql);
    }
    public Advertisement deleteAdvertisementByCategoryId(long categoryId) {
        String sql = "DELETE FROM advertisement WHERE categoryID = ?;";
        return deleteAdvertisement(categoryId, sql);
    }
    //------PRIVATE COMMON METHODS---START----

    private Advertisement deleteAdvertisement(long categoryId, String sql) {
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
    //------PRIVATE COMMON METHODS---END----


    //----------------DELETE METHODS----END------------------------



    //----------------UPDATE METHODS----START------------------------

    public void updateAdvertisement(long advertisementId, String fieldName, String newValue) {
        String sql = String.format("UPDATE advertisement SET %s = ?, updatedAt = ? WHERE id = ?", fieldName);
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, newValue);
            statement.setTimestamp(2, Timestamp.valueOf(TimestampUtil.getCurrentDateTime().truncatedTo(ChronoUnit.SECONDS)));


            statement.setLong(3, advertisementId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }


    //----------------UPDATE METHODS----END------------------------


    //----------------GET METHODS----START------------------------

    public List<Advertisement> getAllAdvertisements() {
        String sql = "SELECT * FROM melifera_db.advertisement";
        return getAdvertisement(sql);
    }
    public List<Advertisement> getActiveAdvertisements() {
        String sql = "SELECT * FROM melifera_db.advertisement where isActive = true";
        return getAdvertisement(sql);
    }
    public List<Advertisement> getUserAdvertisements(long user_id) {
        String sql = "SELECT * FROM melifera_db.advertisement where  advertisement.userID = ?";
        List<Advertisement> advertisements = new ArrayList<>();

        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, user_id);
            ResultSet resultSet = statement.executeQuery();

            return getAllAdvertisements(advertisements, resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Advertisement getAdvertisementById(long advertisement_id) {
        String sql = "SELECT * FROM melifera_db.advertisement where id = ?";
        Advertisement advertisement = null;

        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, advertisement_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                advertisement = createAdvertisementFromResultSet(resultSet);
            }

            return advertisement;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //------PRIVATE COMMON METHODS---START----
    private List<Advertisement> getAllAdvertisements(List<Advertisement> advertisements, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Advertisement advertisement = createAdvertisementFromResultSet(resultSet);
            advertisements.add(advertisement);
        }
        return advertisements;
    }
    private List<Advertisement> getAdvertisement(String sql) {
        List<Advertisement> advertisements = new ArrayList<>();

        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            return getAllAdvertisements(advertisements, resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    //------PRIVATE COMMON METHODS---END----


    //----------------GET METHODS----END------------------------

}
