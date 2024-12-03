package ru.practicum.item;


import java.util.List;

interface ItemService {
    List<ItemDTO> getItems(long userId);
    ItemDTO addNewItem(long userId, ItemDTO itemDTO);
    void deleteItem(long userId, long itemId);
}
