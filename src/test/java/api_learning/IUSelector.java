package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import platform.Platform;

public class IUSelector {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
        navLoginBtn.click();

        MobileElement textDesc = appiumDriver.findElement(MobileBy.AndroidUIAutomator
                ("new UiSelector().textContains(\"When the device\")"));
        System.out.println(textDesc.getText());
    }
}
