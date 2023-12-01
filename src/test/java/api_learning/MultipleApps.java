package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.AppPackage;
import platform.Platform;
import support.SwipeEx;

import java.time.Duration;
import java.util.List;

public class MultipleApps {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        WebDriverWait wait = new WebDriverWait(appiumDriver,2);

        try {
            // Login navigation
            MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtn.click();

            MobileElement emailEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnEle = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            emailEle.sendKeys("teo@sth.com");
            passwordEle.sendKeys("12345678");
            loginBtnEle.click();

            // Put webdriverIO into background || open settings app
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));
            appiumDriver.activateApp(AppPackage.SETTINGS);
            Thread.sleep(1000);

            // Interact internet settings
            MobileElement NetworkInternetEle = appiumDriver.findElement(MobileBy.id("android:id/title"));
            NetworkInternetEle.click();
            Thread.sleep(1000);

            MobileElement InternetEle = appiumDriver.findElement(MobileBy.id("android:id/title"));
            wait.until(ExpectedConditions.visibilityOf(InternetEle));
            InternetEle.click();

            // Turn on/off Wifi
            MobileElement switchEle = appiumDriver.findElement(MobileBy.id("android:id/switch_widget"));
            String isConnectedStr = appiumDriver.findElement(MobileBy
                    .AndroidUIAutomator("new UiSelector().textContains(\"Connected\")")).getText();
            boolean isConnected = isConnectedStr.equalsIgnoreCase("Connected");

            if (!isConnected) {
                switchEle.click();
            }

            // Switch back to webdriverIO app
            appiumDriver.activateApp(AppPackage.WEDDRIVERIO);

            // CLick ok pop-up
            MobileElement okPopupBtn = appiumDriver.findElement(MobileBy.id("android:id/button1"));
            okPopupBtn.click();


        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}


