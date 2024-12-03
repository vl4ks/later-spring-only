package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = repository.findAll();
        return UserMapper.mapToUserDTO(users);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = repository.save(UserMapper.mapToNewUser(userDTO));
        return UserMapper.mapToUserDTO(user);
    }
}