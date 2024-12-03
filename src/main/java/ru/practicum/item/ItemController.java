package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<ItemDTO> get(@RequestHeader("X-Later-User-Id") long userId) {
        return itemService.getItems(userId);
    }

    @PostMapping
    public ItemDTO add(@RequestHeader("X-Later-User-Id") Long userId,
                       @RequestBody ItemDTO itemDTO) {
        return itemService.addNewItem(userId, itemDTO);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@RequestHeader("X-Later-User-Id") long userId,
                           @PathVariable(name="itemId") long itemId) {
        itemService.deleteItem(userId, itemId);
    }
}