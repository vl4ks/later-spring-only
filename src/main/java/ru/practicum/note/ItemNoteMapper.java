package ru.practicum.note;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.practicum.item.Item;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemNoteMapper {
    public static ItemNoteDTO mapToItemNoteDTO(ItemNote itemNote) {
        String dateOfNote = DateTimeFormatter
                .ofPattern("yyyy.MM.dd hh:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(itemNote.getDateOfNote());
        return new ItemNoteDTO(
                itemNote.getId(),
                itemNote.getItem().getId(),
                itemNote.getText(),
                dateOfNote,
                itemNote.getItem().getUrl()
        );
    }
    public static List<ItemNoteDTO> mapToItemNoteDTO(Iterable<ItemNote> itemNotes) {
        List<ItemNoteDTO> dtos = new ArrayList<>();
        for (ItemNote itemNote : itemNotes) {
            dtos.add(mapToItemNoteDTO(itemNote));
        }
        return dtos;
    }
    public static ItemNote mapToItemNote(ItemNoteDTO itemNoteDTO, Item item) {
        ItemNote itemNote = new ItemNote();
        itemNote.setItem(item);
        itemNote.setText(itemNoteDTO.getText());
        return itemNote;
    }
}
