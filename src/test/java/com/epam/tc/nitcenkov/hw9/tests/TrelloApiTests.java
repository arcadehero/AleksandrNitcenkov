package com.epam.tc.nitcenkov.hw9.tests;

import static com.epam.tc.nitcenkov.hw9.tests.TestData.ID_LIST;

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

    @Test(description = "Get board by id -> Check for board name")
    public void getCheckBoardNameTest() {
        BoardDTO justCreatedBoard = new BoardService().getBoardById(TestData.ID_BOARD);
        BoardAssertions.assertBoardName(justCreatedBoard, "A good board");
    }

    @Test(description = "Update board -> Check if it has been updated")
    public void updateBoardCheckIfBoardUpdatedTest() {
        paramsForBoardRequests.put("name", TestData.UPDATE_BOARD_NAME);
        BoardDTO updatedBoardDTO =
            new BoardService().updateBoard(TestData.ID_BOARD, paramsForBoardRequests);
        BoardAssertions
            .assertBoardName(updatedBoardDTO, "Updated board");
    }

    @Test(description = "Create list -> Check for list name")
    public void createListCheckListNameTest() {
        ListDTO listDto = new ListService().createList(paramsForListRequests);
        ListAssertions.assertListName(listDto, "A better list");
    }

    @Test(description = "Create list -> Update list -> Check if it has been updated")
    public void createListUpdateListCheckListUpdatedTest() {
        ListDTO list = new ListService().createList(paramsForListRequests);
        ID_LIST = list.getId();
        paramsForListRequests.put("name", TestData.UPDATE_LIST_NAME);
        list = new ListService().updateList(ID_LIST, paramsForListRequests);
        ListAssertions.assertListName(list, "Updated list");
    }

    @Test(description = "Create list -> Create card -> Check for cardName")
    public void createListCreateCardCheckCardNameTest() {
        ListDTO list = new ListService().createList(paramsForListRequests);
        ID_LIST = list.getId();
        CardDTO card = new CardService(ID_LIST).createCard(paramsForCardRequests, ID_LIST);
        CardAssertions.assertCardName(card, "The best card");
    }

    @Test(description = "Create list -> Create card -> Update card -> Check if it has been updated")
    public void createListCreateCardUpdateCardCheckCardUpdatedTest() {
        ListDTO list = new ListService().createList(paramsForListRequests);
        ID_LIST = list.getId();
        CardDTO card = new CardService(ID_LIST).createCard(paramsForCardRequests, ID_LIST);
        TestData.ID_CARD = card.getId();
        paramsForCardRequests.put("name", TestData.UPDATE_CARD_NAME);
        card = new CardService().updateCard(TestData.ID_CARD, paramsForCardRequests);
        CardAssertions.assertCardName(card, "Updated card");
    }
}
