package service;

import dao.UserDao;
import dto.UserDto;
import enums.UserRole;
import exception.MaxAttemptsExceededException;
import exception.NoAvailableException;
import exception.NotFoundException;
import model.User;
import util.Sha256Util;
import util.ScannerUtil;
import util.SessionManagerUtil;

import java.util.List;

public class UserService {
    private final UserDao userDao;
    private final UserDetailsService userDetailsService;
    private final AdvertisementService advertisementService;


    public UserService(UserDao userDao, UserDetailsService userDetailsService, AdvertisementService advertisementService) {
        this.userDao = userDao;
        this.userDetailsService = userDetailsService;
        this.advertisementService = advertisementService;
    }


    //----------------CREATE METHODS----START------------------------

    public void createUser() {

        String username = ScannerUtil.readString("Username:");
        String password = ScannerUtil.readString("Password:");
        User user = userDao.createUser(new User(username, Sha256Util.hashPassword(password),
                UserRole.USER_ROLE));
        userDetailsService.createUserDetails(user.getId());

    }
    //----------------CREATE METHODS----END------------------------


    //----------------AUTHENTICATE METHODS----START------------------------

    public User authenticateUser() {
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            String username = ScannerUtil.readString("Enter username: ");
            String password = Sha256Util.hashPassword
                    (ScannerUtil.readString("Enter password: "));

            User user = userDao.getUserByUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                SessionManagerUtil.authenticateUser(user.getId());
                return user;
            } else {
                System.out.println("Invalid username or password. Please try again. Attempts remaining: " + (maxAttempts - attempts - 1));
                attempts++;

                if (attempts < maxAttempts) {
                    System.out.println("Attempts remaining: " + (maxAttempts - attempts));
                }
            }
        }
        throw new MaxAttemptsExceededException("Maximum login attempts reached. Please contact support.");
    }


    //----------------AUTHENTICATE METHODS----END------------------------


    //----------------GET METHODS----START------------------------

    public void getUserInformation() {
        UserDto userDetailsDao = userDao.getUserInformation(SessionManagerUtil.getAuthenticatedUserId());

        if (userDetailsDao == null) {
            throw new NotFoundException("User details not found for user ID: " + SessionManagerUtil.getAuthenticatedUserId());
        }

        System.out.println(userDetailsDao);
    }

    public void getUsers() {
        List<UserDto> users = userDao.getUsers();
        if(users.isEmpty()){
            throw new NoAvailableException("No available users ");

        }
        System.out.println(users);
    }

    //----------------GET METHODS----END------------------------


    //----------------DELETE METHODS----START------------------------

    public void deleteUser() {
        getUsers();
        long userId = ScannerUtil.readLong("Enter user id to delete");


        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new NotFoundException("User not found with id: " + userId);
        }

        advertisementService.deleteAdvertisementByUserId(userId);
         userDao.deleteUserAndUserDetails(userId);

    }
    //----------------DELETE METHODS----END------------------------


}


