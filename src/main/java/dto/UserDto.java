package dto;

import enums.UserRole;

import java.util.List;

public class UserDto {
    private final long id;
    private final String username;
    private final String password;
    private final UserRole role;
    private UserDetailsDto userDetailsDto;
    private List<AdvertisementDto> advertisements;


    public UserDto(long id, String username, String password, UserRole role, UserDetailsDto userDetailsDto) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.userDetailsDto = userDetailsDto;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public UserDetailsDto getUserDetailsDto() {
        return userDetailsDto;
    }

    public List<AdvertisementDto> getAdvertisements() {
        return advertisements;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n" + "UserDto" + '\n' +
                "id = " + id + '\n' +
                "username = " + username + '\n' +
                "password = " + password + '\n' +
                "role = " + role + '\n' +
                (userDetailsDto != null ? userDetailsDto.toString() : "No Details");
    }
}
