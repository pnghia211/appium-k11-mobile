package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.io.File;

public class Screenshot {
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);
        WebDriverWait wait = new WebDriverWait(appiumDriver, 1);

        try {
            MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtn.click();

            MobileElement loginScreen = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            wait.until(ExpectedConditions.visibilityOf(loginScreen));

            MobileElement loginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            File base64screenshot = loginBtn.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshot/").concat("LoginButton.png");

            FileUtils.copyFile(base64screenshot, new File(fileLocation));


        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}

