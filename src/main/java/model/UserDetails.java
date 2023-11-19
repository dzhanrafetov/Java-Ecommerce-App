package model;

import java.time.LocalDateTime;
import java.util.List;

public class UserDetails extends BaseEntity {
    private final String firstName;
    private final String lastName;
    private final PhoneNumber phoneNumber;
    private final List<Address> addresses;

    public UserDetails(long id,
                       LocalDateTime createdTime,
                       LocalDateTime updatedTime,
                       String firstName,
                       String lastName,
                       PhoneNumber phoneNumber,
                       List<Address> addresses) {
        super(id, createdTime, updatedTime);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;


    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    @Override
    public String toString() {
        return "UserDetails" + "\n" +
                "firstName = '" + firstName + "' \n" +
                "lastName = '" + lastName + "' \n" +
                "\n" + phoneNumber + " \n" +
                "Addresses" + "\n" + addresses;
    }
}

