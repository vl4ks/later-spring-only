package ru.practicum.item;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.practicum.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class ItemMapper {
    public static Item mapToItem(ItemDTO itemDTO, User user) {
        Item item = new Item();
        item.setUser(user);
        item.setUrl(itemDTO.getUrl());
        item.setTags(itemDTO.getTags());
        return item;
    }

    public static ItemDTO mapToItemDTO(Item item) {
        return new ItemDTO(
                item.getId(),
                item.getUser().getId(),
                item.getUrl(),
                new HashSet<>(item.getTags())
        );
    }

    public static List<ItemDTO> mapToItemDTO(Iterable<Item> items) {
        List<ItemDTO> dtos = new ArrayList<>();
        for (Item item : items) {
            dtos.add(mapToItemDTO(item));
        }
        return dtos;
    }
}
