package com.epam.tc.nitcenkov.hw9.tests;

import static com.epam.tc.nitcenkov.hw9.tests.TestData.BOARD_NAME;
import static com.epam.tc.nitcenkov.hw9.tests.TestData.CARD_NAME;
import static com.epam.tc.nitcenkov.hw9.tests.TestData.LIST_NAME;
import static com.epam.tc.nitcenkov.hw9.util.Util.ID_BOARD;

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
        paramsForBoardRequests.put("name", BOARD_NAME);
        paramsForListRequests.put("name", LIST_NAME);
        paramsForCardRequests.put("name", CARD_NAME);

        BoardDTO board = new BoardService().createBoard(paramsForBoardRequests);
        ID_BOARD = board.getId();
        paramsForListRequests.put("idBoard", ID_BOARD);
    }

    @AfterMethod
    public void tearDown() {
        paramsForBoardRequests.clear();
        paramsForListRequests.clear();
        paramsForCardRequests.clear();
        new BoardService().deleteBoard(ID_BOARD);
    }
}
