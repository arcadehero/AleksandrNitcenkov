package com.epam.tc.nitcenkov.hw9.service;

import com.epam.tc.nitcenkov.hw9.dto.BoardDTO;
import io.restassured.http.Method;
import java.util.Map;

public class BoardService extends BasicService {

    private static final String CREATE = "1/boards";
    private static final String GET_OR_UPDATE_OR_DELETE_BOARD = CREATE + "/";

    public BoardDTO getBoardById(String boardId) {
        return (BoardDTO) readFromResponse(
            requestWithoutParams(GET_OR_UPDATE_OR_DELETE_BOARD + boardId, Method.GET), BoardDTO.class);
    }

    public BoardDTO createBoard(Map<String, String> params) {
        return (BoardDTO) readFromResponse(requestWithParams(CREATE, Method.POST, params), BoardDTO.class);
    }

    public BoardDTO updateBoard(String boardId, Map<String, String> params) {
        return (BoardDTO) readFromResponse(
            requestWithParams(GET_OR_UPDATE_OR_DELETE_BOARD + boardId, Method.PUT, params),
            BoardDTO.class);
    }

    public BoardDTO deleteBoard(String boardId) {
        return (BoardDTO) readFromResponse(requestWithoutParams(GET_OR_UPDATE_OR_DELETE_BOARD + boardId, Method.DELETE),
            BoardDTO.class);
    }
}
