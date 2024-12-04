package ru.practicum.note;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
interface ItemNoteService {
    @Transactional
    ItemNoteDTO addNewItemNote(long userId, ItemNoteDTO itemNoteDto);
    List<ItemNoteDTO> searchNotesByUrl(String url, Long userId);
    List<ItemNoteDTO> searchNotesByTag(long userId, String tag);
    List<ItemNoteDTO> listAllItemsWithNotes(long userId, int from, int size);
}
