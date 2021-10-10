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
import org.testng.annotations.Test;

public class TrelloApiTests extends BaseTests {

    @Test(description = "Get board by id -> Check for boardName")
    public void getCheckBoardNameTest() {
        BoardDTO justCreatedBoard = new BoardService().getBoardById(System.getProperty("boardId"));
        BoardAssertions.assertBoardName(justCreatedBoard.getName(), "A good board");
    }

    @Test(description = "Update board -> Check if it has been updated")
    public void deleteBoardCheckIfBoardDeletedTest() {
        paramsForBoardRequests.put("name", "A better board");
        BoardDTO updatedBoardDTO =
            new BoardService().updateBoard(System.getProperty("boardId"), paramsForBoardRequests);
        BoardAssertions
            .assertBoardUpdated(updatedBoardDTO.getName(), "A better board");
    }

    @Test(description = "Create list -> Get created list by id")
    public void createListCheckListNameTest() {
        ListDTO listDto = new ListService().createList(paramsForListRequests);
        ListAssertions.assertListName(listDto.getName(), "A bad list");
    }

    @Test(description = "Create list -> Update list -> Check if it has been updated")
    public void createListDeleteListCheckListDeletedTest() {
        ListDTO list = new ListService().createList(paramsForListRequests);
        String listId = list.getId();
        paramsForListRequests.put("name", "A worse list");
        list = new ListService().updateList(listId, paramsForListRequests);
        ListAssertions.assertListUpdated(list.getName(), "A worse list");
    }

    @Test(description = "Create list -> Create card -> Check for cardName")
    public void createListCreateCardCheckCardNameTest() {
        ListDTO list = new ListService().createList(paramsForListRequests);
        System.setProperty("idList", list.getId());
        CardDTO card = new CardService(list.getId()).createCard(paramsForCardRequests);
        CardAssertions.assertCardName(card.getName(), "An ugly card");
    }

    @Test(description = "Create list -> Create card -> Update card -> Check if it has been updated")
    public void createListCreateCardDeleteCardCheckCardDeletedTest() {
        ListDTO list = new ListService().createList(paramsForListRequests);
        System.setProperty("idList", list.getId());
        CardDTO card = new CardService(list.getId()).createCard(paramsForCardRequests);
        paramsForCardRequests.put("name", "A more uglier card");
        card = new CardService().updateCard(card.getId(), paramsForCardRequests);
        CardAssertions.assertCardName(card.getName(), "A more uglier card");
    }
}
