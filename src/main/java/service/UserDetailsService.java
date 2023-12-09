package service;

import dao.UserDetailsDao;
import model.UserDetails;
import util.ScannerUtil;
import util.TimestampUtil;

public class UserDetailsService {
    private final UserDetailsDao userDetailsDao;

    public UserDetailsService(UserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }


    //----------------CREATE METHODS----START------------------------

    public void createUserDetails(long userId) {

        String firstName = ScannerUtil.readString("First name:");
        String lastName = ScannerUtil.readString("Last name:");
        String street_address = ScannerUtil.readString("Street address:");
        String city = ScannerUtil.readString("City:");
        String country = ScannerUtil.readString("Country:");
        String postal_code = ScannerUtil.readString("Postal code:");
        String phone_number = ScannerUtil.readString("Phone number:");


        userDetailsDao.createUserDetails(new UserDetails(
                TimestampUtil.getCurrentDateTime(),
                TimestampUtil.getCurrentDateTime(),
                firstName,
                lastName,
                street_address,
                city,
                country,
                postal_code,
                phone_number,
                userId
        ));
    }

    //----------------CREATE METHODS----END------------------------


}
