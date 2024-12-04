package ru.practicum.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageRequest;
import ru.practicum.item.Item;
import ru.practicum.item.ItemRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemNoteServiceImpl implements ItemNoteService {
    private final ItemNoteRepository itemNoteRepository;
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public ItemNoteDTO addNewItemNote(long userId, ItemNoteDTO itemNoteDTO) {
        Item item = itemRepository.findById(itemNoteDTO.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));
        ItemNote itemNote = itemNoteRepository.save(ItemNoteMapper.mapToItemNote(itemNoteDTO, item));
        return ItemNoteMapper.mapToItemNoteDTO(itemNote);
    }

    @Override
    public List<ItemNoteDTO> searchNotesByUrl(String url, Long userId) {
        List<ItemNote> itemNotes = itemNoteRepository.findAllByItemUrlContainingAndItemUserId(url, userId);
        return ItemNoteMapper.mapToItemNoteDTO(itemNotes);
    }
    @Override
    public List<ItemNoteDTO> searchNotesByTag(long userId, String tag) {
        List<ItemNote> itemNotes = itemNoteRepository.findByTag(userId, tag);
        return ItemNoteMapper.mapToItemNoteDTO(itemNotes);
    }
    @Override
    public List<ItemNoteDTO> listAllItemsWithNotes(long userId, int from, int size) {
        PageRequest page = PageRequest.of(from > 0 ? from / size : 0, size);
        return itemNoteRepository.findAllByItemUserId(userId, page)
                .map(ItemNoteMapper::mapToItemNoteDTO)
                .getContent();
    }
}
