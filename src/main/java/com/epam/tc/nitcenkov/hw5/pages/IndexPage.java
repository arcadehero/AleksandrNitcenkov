package com.epam.tc.nitcenkov.hw5.pages;

import com.epam.tc.nitcenkov.hw5.components.HeaderMenuComponent;
import com.epam.tc.nitcenkov.hw5.components.LogComponent;
import com.epam.tc.nitcenkov.hw5.components.LoginComponent;
import org.openqa.selenium.WebDriver;

public class IndexPage extends AbstractBasePage {

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent;
    }


}
