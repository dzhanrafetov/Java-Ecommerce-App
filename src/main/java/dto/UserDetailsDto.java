package dto;

import model.UserDetails;
import service.UserService;

public class UserDetailsDto {
    private final String firstName;
    private final String lastName;
    private final String streetAddress;
    private final String city;
    private final String country;
    private final String postalCode;
    private final String phoneNumber;
    private final long userID;

    public UserDetailsDto(String firstName, String lastName, String streetAddress, String city, String country, String postalCode, String phoneNumber, long userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.userID=userID;
    }

    public static UserDetailsDto convert(UserDetails userDetails) {
        return new UserDetailsDto(
                userDetails.getFirstName(),
                userDetails.getLastName(),
                userDetails.getStreetAddress(),
                userDetails.getCity(),
                userDetails.getCountry(),
                userDetails.getPostalCode(),
                userDetails.getPhoneNumber(),
                userDetails.getUserID());
}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return
                "UserDetailsDto" + "\n" +
                "firstName = " + firstName + '\n' +
                "lastName = " + lastName + '\n' +
                "streetAddress = " + streetAddress + '\n' +
                "city = " + city + '\n' +
                "country = " + country + '\n' +
                "phoneNumber = " + phoneNumber + '\n' ;
    }
}
