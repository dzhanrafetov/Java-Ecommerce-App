package dao;

import model.UserDetails;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UserDetailsDao {

    public UserDetails createUserDetails(UserDetails userDetails) {
        String sql = " INSERT INTO userdetails (firstName, lastName,street_address,city,country,postal_code,phone_number,createdAt,updatedAt,userID) VALUES (?,?,?,?,?,?,?,?,?,?) ";
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, userDetails.getFirstName());
            statement.setString(2, userDetails.getLastName());
            statement.setString(3, userDetails.getStreetAddress());
            statement.setString(4, userDetails.getCity());
            statement.setString(5, userDetails.getCountry());
            statement.setString(6, userDetails.getPostalCode());
            statement.setString(7, userDetails.getPhoneNumber());

            LocalDateTime createdAt = userDetails.getCreatedAt().truncatedTo(ChronoUnit.SECONDS);
            LocalDateTime updatedAt = userDetails.getUpdatedAt().truncatedTo(ChronoUnit.SECONDS);

            statement.setTimestamp(8, Timestamp.valueOf(createdAt));
            statement.setTimestamp(9, Timestamp.valueOf(updatedAt));
            statement.setLong(10,userDetails.getUserID());


            statement.executeUpdate();
            return userDetails;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
