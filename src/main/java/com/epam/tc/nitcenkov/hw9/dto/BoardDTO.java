package com.epam.tc.nitcenkov.hw9.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    protected String name;
    protected String desc;
    protected boolean closed;
    protected String dateClosed;
    protected String idOrganization;
    protected boolean pinned;
    protected String idBoardSource;
    protected String idMemberCreator;
    protected String id;
    protected String url;
}


