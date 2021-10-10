package com.epam.tc.nitcenkov.hw9.tests;

import com.epam.tc.nitcenkov.hw9.dto.BoardDTO;
import com.epam.tc.nitcenkov.hw9.service.BoardService;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

    Map<String, String> paramsForBoardRequests = new HashMap<>();
    Map<String, String> paramsForListRequests = new HashMap<>();
    Map<String, String> paramsForCardRequests = new HashMap<>();

    @BeforeMethod
    public void setUp() {
        paramsForBoardRequests.put("name", TestData.BOARD_NAME);
        paramsForListRequests.put("name", TestData.LIST_NAME);
        paramsForCardRequests.put("name", TestData.CARD_NAME);

        BoardDTO board = new BoardService().createBoard(paramsForBoardRequests);
        System.setProperty("boardId", board.getId());
        paramsForListRequests.put("idBoard", board.getId());
    }

    @AfterMethod
    public void tearDown() {
        paramsForBoardRequests.clear();
        paramsForListRequests.clear();
        paramsForCardRequests.clear();
        new BoardService().deleteBoard(System.getProperty("boardId"));
    }
}
