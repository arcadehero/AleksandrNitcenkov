package com.epam.tc.nitcenkov.hw9.tests;

import com.epam.tc.nitcenkov.hw9.assertions.BoardAssertions;
import com.epam.tc.nitcenkov.hw9.assertions.CardAssertions;
import com.epam.tc.nitcenkov.hw9.assertions.ListAssertions;
import com.epam.tc.nitcenkov.hw9.dto.BoardDTO;
import com.epam.tc.nitcenkov.hw9.dto.CardDTO;
import com.epam.tc.nitcenkov.hw9.dto.ListDTO;
import com.epam.tc.nitcenkov.hw9.service.BoardService;
import com.epam.tc.nitcenkov.hw9.service.CardService;
import com.epam.tc.nitcenkov.hw9.service.ListService;
import com.epam.tc.nitcenkov.hw9.util.Util;
import org.testng.annotations.Test;

public class TrelloApiTests extends BaseTests {

    @Test(description = "Get board by id -> Check for boardName")
    public void getCheckBoardNameTest() {
        BoardDTO justCreatedBoard = new BoardService().getBoardById(Util.ID_BOARD);
        BoardAssertions.assertBoardName(justCreatedBoard, "A good board");
    }

    @Test(description = "Update board -> Check if it has been updated")
    public void deleteBoardCheckIfBoardDeletedTest() {
        paramsForBoardRequests.put("name", "A better board");
        BoardDTO updatedBoardDTO =
            new BoardService().updateBoard(Util.ID_BOARD, paramsForBoardRequests);
        BoardAssertions
            .assertBoardName(updatedBoardDTO, "A better board");
    }

    @Test(description = "Create list -> Get created list by id")
    public void createListCheckListNameTest() {
        ListDTO listDto = new ListService().createList(paramsForListRequests);
        ListAssertions.assertListName(listDto, "A better list");
    }

    @Test(description = "Create list -> Update list -> Check if it has been updated")
    public void createListDeleteListCheckListDeletedTest() {
        ListDTO list = new ListService().createList(paramsForListRequests);
        Util.ID_LIST = list.getId();
        paramsForListRequests.put("name", "A worse list");
        list = new ListService().updateList(Util.ID_LIST, paramsForListRequests);
        ListAssertions.assertListName(list, "A worse list");
    }

    @Test(description = "Create list -> Create card -> Check for cardName")
    public void createListCreateCardCheckCardNameTest() {
        ListDTO list = new ListService().createList(paramsForListRequests);
        Util.ID_LIST = list.getId();
        CardDTO card = new CardService(Util.ID_LIST).createCard(paramsForCardRequests);
        CardAssertions.assertCardName(card, "The best card");
    }

    @Test(description = "Create list -> Create card -> Update card -> Check if it has been updated")
    public void createListCreateCardDeleteCardCheckCardDeletedTest() {
        ListDTO list = new ListService().createList(paramsForListRequests);
        Util.ID_LIST = list.getId();
        CardDTO card = new CardService(Util.ID_LIST).createCard(paramsForCardRequests);
        Util.ID_CARD = card.getId();
        paramsForCardRequests.put("name", "A more uglier card");
        card = new CardService().updateCard(Util.ID_CARD, paramsForCardRequests);
        CardAssertions.assertCardName(card, "A more uglier card");
    }
}
