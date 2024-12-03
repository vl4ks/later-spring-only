package ru.practicum.user;

import java.util.List;

interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO saveUser(UserDTO userDTO);
}
