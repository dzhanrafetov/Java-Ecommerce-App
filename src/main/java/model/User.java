package model;

import dto.AdvertisementDto;
import dto.UserDetailsDto;
import enums.UserRole;

import java.util.List;

public class User extends BaseEntity {
    private final String username;
    private final String password;
    private final UserRole role;
    private UserDetails userDetails;
    private List<AdvertisementDto> advertisements;


    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(long id, String username, String password, UserRole role) {
        super(id);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(long id, String username, String password, UserRole role, UserDetails userDetails, List<AdvertisementDto> advertisements) {
        super(id);
        this.username = username;
        this.password = password;
        this.role = role;
        this.userDetails = userDetails;
        this.advertisements = advertisements;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public UserRole getRole() {
        return this.role;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public List<AdvertisementDto> getAdvertisements() {
        return advertisements;
    }

    @Override
    public String toString() {
        return "\n" + "User" + "\n" +
                "id = '" + super.getId() + "' \n" +
                "username = '" + username + "' \n" +
                "password = '" + password + "' \n" +
                "role = '" + role + "'\n";
    }
}
