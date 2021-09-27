package com.epam.tc.nitcenkov.hw9;

import com.epam.tc.nitcenkov.hw9.dto.BoardDTO;
import com.epam.tc.nitcenkov.hw9.dto.ListDTO;
import com.epam.tc.nitcenkov.hw9.service.BoardService;
import com.epam.tc.nitcenkov.hw9.service.ListService;
import org.testng.annotations.Test;

public class TrelloApiTests extends BaseTests {

    @Test(description = "Create board -> Get board by id")
    public void createGetBoard() {
        BoardDTO boardDto = new BoardService().createBoard(paramsForBoardRequests);
        String boardId = boardDto.getId();
        BoardDTO justCreatedBoard = new BoardService().getBoardById(boardId);
        softAssertions.assertThat(justCreatedBoard.getName()).isEqualTo("board");
    }

    @Test(description = "Create board -> Delete board -> Check if it has been deleted")
    public void createDeleteBoard() {
        BoardDTO boardDto = new BoardService().createBoard(paramsForBoardRequests);
        softAssertions.assertThat(new BoardService().deleteBoard(boardDto.getId()))
                      .hasFieldOrPropertyWithValue("_value", null);
    }

    @Test(description = "Create board -> Create list -> Get created list by id")
    public void createBoardCreateListGetCreatedListById() {
        BoardDTO boardDto = new BoardService().createBoard(paramsForBoardRequests);
        String idBoard = boardDto.getId();
        paramsForListRequests.put("idBoard", idBoard);
        ListDTO listDto = new ListService().createList(paramsForListRequests);
        new ListService().getListById(listDto.getId());
    }

    @Test(description = "Create board -> Create list -> Delete board -> Check if it has been deleted")
    public void createBoardCreateListDeleteBoard() {
        BoardDTO boardDto = new BoardService().createBoard(paramsForBoardRequests);
        String idBoard = boardDto.getId();
        paramsForListRequests.put("idBoard", idBoard);
        new ListService().createList(paramsForListRequests);
        softAssertions.assertThat(new BoardService().deleteBoard(idBoard)).hasFieldOrPropertyWithValue("_value", null);
    }

    @Test(description = "Create board -> Create list -> Delete list -> Check if it has been deleted")
    public void createBoardCreateListDeleteListCheckList() {
        BoardDTO boardDto = new BoardService().createBoard(paramsForBoardRequests);
        String idBoard = boardDto.getId();
        paramsForListRequests.put("idBoard", idBoard);
        ListDTO list = new ListService().createList(paramsForListRequests);
        softAssertions.assertThat(new ListService().deleteList(list.getId()))
                      .hasFieldOrPropertyWithValue("closed", true);
    }
}
