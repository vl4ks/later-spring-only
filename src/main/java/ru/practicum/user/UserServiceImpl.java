package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        List<User> users = repository.findAll();
        return UserMapper.mapToUserDTO(users);
    }

    @Override
    @Transactional
    public UserDTO saveUser(UserDTO userDTO) {
        User user = repository.save(UserMapper.mapToNewUser(userDTO));
        return UserMapper.mapToUserDTO(user);
    }
}