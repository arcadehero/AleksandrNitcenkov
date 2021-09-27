package com.epam.tc.nitcenkov.hw9.service;

import com.epam.tc.nitcenkov.hw9.dto.BoardDTO;
import com.google.gson.GsonBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;

public class BoardService extends BasicService {

    private static final String GET_OR_UPDATE_OR_DELETE_BOARD = "1/boards/";
    private static final String CREATE = "1/boards";

    public static BoardDTO readBoardFromResponse(Response response) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(response.getBody().asString(),
                                    BoardDTO.class);
    }

    public  BoardDTO getBoardById(String boardId) {
        return readBoardFromResponse(requestWithoutParams(GET_OR_UPDATE_OR_DELETE_BOARD + boardId, Method.GET));
    }

    public  BoardDTO createBoard(Map<String, String> params) {
        return readBoardFromResponse(requestWithParams(CREATE, Method.POST, params));
    }

    public  BoardDTO updateBoard(String boardId, Map<String, String> params) {
        return readBoardFromResponse(requestWithParams(GET_OR_UPDATE_OR_DELETE_BOARD + boardId, Method.PUT, params));
    }

    public  BoardDTO deleteBoard(String boardId) {
        return readBoardFromResponse(requestWithoutParams(GET_OR_UPDATE_OR_DELETE_BOARD + boardId, Method.DELETE));
    }
}
