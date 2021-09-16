package com.epam.tc.nitcenkov.hw5.cucumber.steps;

import com.epam.tc.nitcenkov.hw5.util.Util;
import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        indexPage.open();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void login() {
        indexPage.getHeaderMenuComponent().clickOnUserIcon();
        indexPage.getLoginComponent().performLogin(Util.LOGIN, Util.PASSWORD);
    }


}
