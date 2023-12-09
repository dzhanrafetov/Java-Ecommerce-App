package dto.converters;

import dto.UserDetailsDto;
import dto.UserDto;
import model.User;

public class UserDtoConverter {

    public static UserDto convert(User user, UserDetailsDto userDetailsDto) {

        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                userDetailsDto
        );


    }

}
