package model;

import enums.UserRole;

import java.util.Enumeration;

public class User extends BaseEntity {
    private final String username;
    private final String password;
    private final UserRole role;

    private final UserDetails userDetails;


    public User(long id, String username, String password, UserRole role, UserDetails userDetails) {
        super(id);
        this.username = username;
        this.password = password;
        this.role = role;
        this.userDetails = userDetails;
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

    public UserDetails userDetails() {
        return this.userDetails;
    }

    @Override
    public String toString() {
        return "\n" + "User" + "\n" +
                "id = " + super.getId() + " \n" +

                "username = '" + username + "' \n" +
                "password = '" + password + "' \n" +
                "role = '" + role + "'\n" +
                "\n" + userDetails + " \n";
    }
}
