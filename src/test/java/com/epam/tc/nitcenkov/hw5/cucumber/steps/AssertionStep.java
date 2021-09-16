package com.epam.tc.nitcenkov.hw5.cucumber.steps;

import static com.epam.tc.nitcenkov.hw5.cucumber.Constants.EXPECTED_LOG_ROW;
import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AssertionStep extends AbstractStep {

    @Then("For every chosen item there is individual log row")
    public void checkForVisibility() {
        assertThat(differentElementPage.getLogComponent().isLogRowDisplayed()).isTrue();
    }

    @Then("The value is corresponded to the status of elements")
    public void checkForLogRowsCorrectness() {
        assertThat(differentElementPage.getLogComponent().getLogRows()).isEqualTo(EXPECTED_LOG_ROW);
    }

    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void checkForTextInLogSection() {
        List<String> actualLogRow = userTablePage.getLogComponent().getLogRows();
        assertThat(actualLogRow).contains("Vip condition changed to true");
    }

    @Then("\"User Table\" page should be opened")
    public void checkForUserTablePageTitle() {
        assertThat(userTablePage.getTitle()).isEqualTo("User Table");
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkSixNumbersShouldBeDisplayedOnUserTable() {
        assertThat(userTablePage.isSixNumberTypeDisplayed()).isTrue();
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void checkSixUsernamesShouldBeDisplayedOnUserTable() {
        assertThat(userTablePage.isSixUsernamesDisplayed()).isTrue();
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void checkSixDescriptionTextsUnderImagesShouldBeDisplayedOnUserTable() {
        assertThat(userTablePage.isSixDescriptionTextsUnderImagesDisplayed()).isTrue();
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkSixCheckboxesShouldBeDisplayedOnUserTable() {
        assertThat(userTablePage.isSixCheckboxesDisplayed()).isTrue();
    }

    @Then("User table should contain following {string} number {string} user {string} description values:")
    public void checkUserTableForNumberUserDescriptionValues(String number, String user, String description) {
        assertThat(userTablePage.getUserTable()).contains(Arrays.asList(number, user, description));
    }

    @Then("Droplist should contain values in column Type for user Roman")
    public void checkDroplistForValuesInColumnTypeForUserRoman(DataTable datatable) {
        List<String> expectedDroplistValues = datatable.asList()
                                                       .stream()
                                                       .skip(1)
                                                       .collect(Collectors.toList());

        assertThat(userTablePage.getDropdownForRoman()).isEqualTo(expectedDroplistValues);
    }
}
