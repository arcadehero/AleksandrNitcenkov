package com.epam.tc.nitcenkov.hw6.listener;

import com.epam.tc.nitcenkov.hw6.util.AttachmentsUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver != null) {
            AttachmentsUtil.screenshotAttachment("Screenshot on failure",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    }
}
