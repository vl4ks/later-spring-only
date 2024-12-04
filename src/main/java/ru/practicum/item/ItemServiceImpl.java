package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    @Override
    public List<ItemDTO> getItems(long userId) {
        List<Item> userItems = repository.findByUserId(userId);
        return ItemMapper.mapToItemDTO(userItems);
    }

    @Override
    @Transactional
    public ItemDTO addNewItem(long userId, ItemDTO itemDTO) {
        Item item = repository.save(ItemMapper.mapToItem(itemDTO, userId));
        return ItemMapper.mapToItemDTO(item);
    }

    @Override
    @Transactional
    public void deleteItem(long userId, long itemId) {
        repository.deleteByUserIdAndId(userId, itemId);
    }
}

