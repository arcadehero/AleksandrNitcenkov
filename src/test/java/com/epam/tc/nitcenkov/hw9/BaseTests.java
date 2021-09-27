package com.epam.tc.nitcenkov.hw9;

import com.epam.tc.nitcenkov.hw9.util.Util;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTests {

    SoftAssertions softAssertions = new SoftAssertions();
    Map<String, String> paramsForBoardRequests = new HashMap<>();
    Map<String, String> paramsForListRequests = new HashMap<>();
    Map<String, String> paramsForCardRequests = new HashMap<>();

    @BeforeTest
    public void setUp() {
        paramsForBoardRequests.put("name", Util.BOARD_NAME);
        paramsForListRequests.put("name", Util.LIST_NAME);
        paramsForCardRequests.put("name", Util.CARD_NAME);
    }

    @AfterTest
    public void tearDown() {
        paramsForBoardRequests.clear();
        paramsForListRequests.clear();
        paramsForCardRequests.clear();
    }


}
