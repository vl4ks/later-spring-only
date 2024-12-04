package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<ItemDTO> get(@RequestHeader("X-Later-User-Id") long userId,
                             @RequestParam(name = "tags", required = false) Set<String> tags) {
        if(tags == null || tags.isEmpty()) {
            return itemService.getItems(userId);
        } else {
            return itemService.getItems(userId, tags);
        }
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