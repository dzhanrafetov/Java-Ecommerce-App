package dao;

import dto.UserDetailsDto;
import dto.UserDto;
import dto.converters.UserDtoConverter;
import enums.UserRole;
import model.User;
import model.UserDetails;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    //----------------CREATE METHODS----START------------------------

    public User createUser(User user) {
        String sql = "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";

        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole().name());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user = new User(generatedKeys.getLong(1), user.getUsername(), user.getPassword(), user.getRole());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return user;
    }

    //----------------CREATE METHODS----END------------------------


    //----------------GET METHODS----START------------------------

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?;";
        User user = null;
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        UserRole.valueOf(resultSet.getString("role")));
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public User getUserById(long id) {
        String sql = "SELECT * FROM user WHERE id = ?;";
        User user = null;
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        UserRole.valueOf(resultSet.getString("role")));
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<UserDto> getUsers() {
        String sql = "SELECT user.id,username,password,role,firstname,lastname,street_address,city,country,postal_code,phone_number,userID FROM melifera_db.user  JOIN  userDetails on user.id = userDetails.userID";
        List<UserDto> userList = new ArrayList<>();
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        UserRole.valueOf(resultSet.getString("role")));

                UserDetails userDetails = new UserDetails(
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("street_address"),
                        resultSet.getString("city"),
                        resultSet.getString("country"),
                        resultSet.getString("postal_code"),
                        resultSet.getString("phone_number"),
                        resultSet.getLong("userID"));

                userList.add(UserDtoConverter.convert(user, UserDetailsDto.convert(userDetails)));
            }
            return userList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserDto getUserInformation(long id) {
        String sql = "select * from user  JOIN userDetails on user.id= userDetails.userID where user.id = ?";
        User user = null;
        UserDetails userDetails = null;
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        UserRole.valueOf(resultSet.getString("role")));

                userDetails = new UserDetails(
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("street_address"),
                        resultSet.getString("city"),
                        resultSet.getString("country"),
                        resultSet.getString("postal_code"),
                        resultSet.getString("phone_number"),
                        resultSet.getLong("userID"));


            }
            if (userDetails != null) {
                return UserDtoConverter.convert(user, UserDetailsDto.convert(userDetails));
            } else
                return null;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //----------------GET METHODS----END------------------------


    //----------------DELETE METHODS----START------------------------

    public User deleteUserAndUserDetails(long user_id) {

        deleteUserDetails(user_id);

        deleteUser(user_id);


        return null;
    }

    //------PRIVATE COMMON METHODS---START----

    private void deleteUser(long user_id) {
        String sql = "DELETE FROM user WHERE  id = ?;";
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, user_id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUserDetails(long user_id) {
        String sql = "DELETE FROM userdetails WHERE  userID = ?;";
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, user_id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------PRIVATE COMMON METHODS---END----

    //----------------DELETE METHODS----END------------------------

}


