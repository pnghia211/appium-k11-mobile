package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import platform.Lesson02_Platform;

public class Lesson03_IUSelector {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

        MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
        navLoginBtn.click();

        MobileElement textDesc = appiumDriver.findElement(MobileBy.AndroidUIAutomator
                ("new UiSelector().textContains(\"When the device\")"));
        System.out.println(textDesc.getText());
    }
}
