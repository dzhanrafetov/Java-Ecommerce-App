package model;


import java.time.LocalDateTime;

public class UserDetails extends BaseEntity {
    private final String firstName;
    private final String lastName;
    private final String streetAddress;
    private final String city;
    private final String country ;
    private final String postalCode;
    private final String phoneNumber;
    private final long userID ;


    public UserDetails(LocalDateTime createdAt,
                       LocalDateTime updatedAt,
                       String firstName,
                       String lastName,
                       String streetAddress,
                       String city,
                       String country,
                       String postalCode,
                       String phoneNumber,
                       long userID) {
        super(createdAt,updatedAt);
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.userID = userID;
    }

    public UserDetails( String firstName, String lastName, String streetAddress, String city, String country, String postalCode, String phoneNumber, long userID) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.userID = userID;
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
        return "UserDetails" + "\n" +
                "id = '" + super.getId() + "' \n" +
                "firstName = '" + firstName + "' \n" +
                "lastName = '" + lastName + "' \n" ;

    }
}

