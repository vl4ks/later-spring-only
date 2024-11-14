package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> userStorage = new HashMap<>();
    private long idGenerator = 1;

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userStorage.values());
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idGenerator++);
        }

        userStorage.put(user.getId(), user);
        return user;
    }
}
