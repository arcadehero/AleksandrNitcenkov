package com.epam.tc.nitcenkov.hw9.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private String name;
    private String desc;
    private boolean closed;
    private String dateClosed;
    private String idOrganization;
    private boolean pinned;
    private String idBoardSource;
    private String idMemberCreator;
    private String id;
    private String url;
}
