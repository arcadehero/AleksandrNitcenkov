package com.epam.tc.nitcenkov.hw9.service;

import com.epam.tc.nitcenkov.hw9.dto.ListDTO;
import com.google.gson.GsonBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;

public class ListService extends BasicService {

    private static final String CREATE_LIST = "1/lists";
    private static final String GET_LIST_BY_ID_OR_UPDATE_OR_DELETE = "1/lists/";

    public ListDTO readListFromResponse(Response response) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(response.getBody().asString(),
                                    ListDTO.class);
    }

    public ListDTO getListById(String listId) {
        return readListFromResponse(requestWithoutParams(GET_LIST_BY_ID_OR_UPDATE_OR_DELETE + listId, Method.GET));
    }

    public ListDTO createList(Map<String, String> params) {
        return readListFromResponse(requestWithParams(CREATE_LIST, Method.POST, params));
    }

    public ListDTO updateList(String listId) {
        return readListFromResponse(requestWithoutParams(GET_LIST_BY_ID_OR_UPDATE_OR_DELETE + listId, Method.PUT));
    }

    public ListDTO deleteList(String listId) {
        return readListFromResponse(
            requestWithoutParams(GET_LIST_BY_ID_OR_UPDATE_OR_DELETE + listId + "/closed", Method.PUT));
    }
}
