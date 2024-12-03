package ru.practicum.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO implements Serializable {
    private Long id;
    private Long userId;
    private String url;
    private Set<String> tags;
}
