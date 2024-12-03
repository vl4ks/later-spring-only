package ru.practicum.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class UserMapper {
    public static UserDTO mapToUserDTO(User user) {
        String regDate = DateTimeFormatter
                .ofPattern("yyyy.MM.dd hh:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(user.getRegistrationDate());

        return new UserDTO(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), regDate, user.getState());
    }

    public static List<UserDTO> mapToUserDTO(Iterable<User> users) {
        List<UserDTO> result = new ArrayList<>();

        for (User user : users) {
            result.add(mapToUserDTO(user));
        }

        return result;
    }

    public static User mapToNewUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setState(userDTO.getState());
        return user;
    }
}

