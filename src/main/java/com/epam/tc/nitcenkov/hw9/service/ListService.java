package com.epam.tc.nitcenkov.hw9.service;

import com.epam.tc.nitcenkov.hw9.dto.ListDTO;
import io.restassured.http.Method;
import java.util.Map;

public class ListService extends BasicService {

    private static final String CREATE_LIST = "1/lists";
    private static final String GET_LIST_BY_ID_OR_UPDATE_OR_DELETE = CREATE_LIST + "/";

    public ListDTO getListById(String listId) {
        return (ListDTO) readFromResponse(requestWithoutParams(GET_LIST_BY_ID_OR_UPDATE_OR_DELETE + listId, Method.GET),
            ListDTO.class);
    }

    public ListDTO createList(Map<String, String> params) {
        return (ListDTO) readFromResponse(requestWithParams(CREATE_LIST, Method.POST, params), ListDTO.class);
    }

    public ListDTO updateList(String listId, Map<String, String> params) {
        return (ListDTO) readFromResponse(
            requestWithParams(GET_LIST_BY_ID_OR_UPDATE_OR_DELETE + listId, Method.PUT, params),
            ListDTO.class);
    }

    public ListDTO deleteList(String listId) {
        return (ListDTO) readFromResponse(
            requestWithoutParams(GET_LIST_BY_ID_OR_UPDATE_OR_DELETE + listId + "/closed", Method.PUT), ListDTO.class);
    }
}
