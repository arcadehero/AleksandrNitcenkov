package com.epam.tc.nitcenkov.hw9.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private String id;
    private String checkItemStates;
    private boolean closed;
    private String idBoard;
    private String idList;
    private String name;
    private String pos;
    private String shortLink;
}
