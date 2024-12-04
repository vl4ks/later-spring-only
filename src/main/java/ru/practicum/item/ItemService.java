package ru.practicum.item;


import java.util.List;
import java.util.Set;

interface ItemService {
    List<ItemDTO> getItems(long userId);
    List<ItemDTO> getItems(long userId, Set<String> tags);
    ItemDTO addNewItem(long userId, ItemDTO itemDTO);
    void deleteItem(long userId, long itemId);
}
