package com.epam.tc.nitcenkov.hw9.service;

import com.epam.tc.nitcenkov.hw9.dto.CardDTO;
import com.google.gson.GsonBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;

public class CardService extends BasicService {

    private static final String CREATE_CARD = "1/cards";
    private static final String GET_CARD_BY_ID_OR_UPDATE_OR_DELETE = "1/cards/";

    public CardDTO readCardFromResponse(Response response) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(response.getBody().asString(),
                                    CardDTO.class);
    }

    public CardDTO getCardById(String cardId) {
        return readCardFromResponse(requestWithoutParams(GET_CARD_BY_ID_OR_UPDATE_OR_DELETE + cardId, Method.GET));
    }

    public CardDTO createCard(Map<String, String> params) {
        return readCardFromResponse((requestWithParams(CREATE_CARD, Method.PUT, params)));
    }

    public CardDTO updateCard(String cardId, Map<String, String> params) {
        return readCardFromResponse(requestWithParams(GET_CARD_BY_ID_OR_UPDATE_OR_DELETE + cardId, Method.GET, params));
    }

    public CardDTO deleteCard(String cardId) {
        return readCardFromResponse(requestWithoutParams(GET_CARD_BY_ID_OR_UPDATE_OR_DELETE + cardId, Method.DELETE));
    }
}
