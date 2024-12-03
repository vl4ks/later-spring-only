package ru.practicum.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByUserId(long userId);

    Item save(Item item);

    void deleteByUserIdAndId(long userId, long itemId);
}
