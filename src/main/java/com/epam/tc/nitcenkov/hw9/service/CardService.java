package com.epam.tc.nitcenkov.hw9.service;

import com.epam.tc.nitcenkov.hw9.dto.CardDTO;
import io.restassured.http.Method;
import java.util.Map;

public class CardService extends BasicService {

    private static final String CREATE_CARD = "1/cards";
    private static final String GET_CARD_BY_ID_OR_UPDATE_OR_DELETE = CREATE_CARD + "/";

    public CardService(String listId) {
    }

    public CardService() {
    }

    public CardDTO getCardById(String cardId) {
        return (CardDTO) readFromResponse(requestWithoutParams(GET_CARD_BY_ID_OR_UPDATE_OR_DELETE + cardId, Method.GET),
            CardDTO.class);
    }

    public CardDTO createCard(Map<String, String> params, String idList) {
        return (CardDTO) readFromResponse((requestWithParamsForCards(CREATE_CARD, Method.POST, params, idList)),
            CardDTO.class);
    }

    public CardDTO updateCard(String cardId, Map<String, String> params) {
        return (CardDTO) readFromResponse(
            requestWithParams(GET_CARD_BY_ID_OR_UPDATE_OR_DELETE + cardId, Method.PUT, params),
            CardDTO.class);
    }

    public CardDTO deleteCard(String cardId) {
        return (CardDTO) readFromResponse(
            requestWithoutParams(GET_CARD_BY_ID_OR_UPDATE_OR_DELETE + cardId, Method.DELETE),
            CardDTO.class);
    }
}
