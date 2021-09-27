package com.epam.tc.nitcenkov.hw9.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    protected String id;
    protected String checkItemStates;
    protected boolean closed;
    protected String idBoard;
    protected String idList;
    protected String name;
    protected String pos;
    protected String shortLink;
}
