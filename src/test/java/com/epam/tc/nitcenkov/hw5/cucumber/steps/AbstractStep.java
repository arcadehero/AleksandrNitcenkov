package com.epam.tc.nitcenkov.hw5.cucumber.steps;

import com.epam.tc.nitcenkov.hw5.cucumber.context.TestContext;
import com.epam.tc.nitcenkov.hw5.pages.DifferentElementPage;
import com.epam.tc.nitcenkov.hw5.pages.IndexPage;
import com.epam.tc.nitcenkov.hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected IndexPage indexPage;
    protected DifferentElementPage differentElementPage;
    protected UserTablePage userTablePage;

    public AbstractStep() {
        WebDriver webDriver = TestContext.getInstance().getTestObject("web-driver");
        indexPage = new IndexPage(webDriver);
        differentElementPage = new DifferentElementPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
    }
}
