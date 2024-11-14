package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private final Map<Long, List<Item>> storage = new HashMap<>();
    private long idGenerator = 1;

    @Override
    public List<Item> findByUserId(long userId) {
        return storage.getOrDefault(userId, new ArrayList<>());
    }

    @Override
    public Item save(Item item) {
            item.setId(idGenerator++);
        storage.computeIfAbsent(item.getUserId(), k -> new ArrayList<>()).add(item);
        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        List<Item> items = storage.get(userId);
        if (items != null) {
            items.removeIf(item -> item.getId() == itemId);
        }
    }
}
