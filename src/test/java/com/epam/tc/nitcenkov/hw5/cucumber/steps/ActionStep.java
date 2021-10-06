package com.epam.tc.nitcenkov.hw5.cucumber.steps;

import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {


    @When("I click on Checkboxes, Radio and Dropdown")
    public void selectOptions() {
        differentElementPage.clickWaterCheckBox();
        differentElementPage.clickWindCheckBox();
        differentElementPage.clickRadioButton();
        differentElementPage.clickChooseColorButton();
        differentElementPage.clickYellowButton();
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckboxForSergeyIvan() {
        userTablePage.clickOnCheckboxIvan();
    }


    @When("I click on \"Service\" button in Header")
    public void clickOnServiceButtonInHeader() {
        indexPage.getHeaderMenuComponent().clickOnServiceButton();
    }

    @When("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableButton() {
        indexPage.getHeaderMenuComponent().clickOnUserTableButton();
    }

    @When("I click on \"Different Elements\" button in Service dropdown")
    public void clickOnDifferentElementsButton() {
        indexPage.getHeaderMenuComponent().clickOnDifferentElementsButton();
    }
}
