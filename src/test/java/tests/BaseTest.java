package tests;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import platform.Platform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseTest {
    public static AppiumDriver<MobileElement> appiumDriver;

    @BeforeTest
    public void initAppiumSession() {
        appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
    }

    @AfterTest(alwaysRun = true)
    public void quitAppiumSession() {
        appiumDriver.quit();
    }
}
