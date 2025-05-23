package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Lesson02_Platform;

import java.io.File;

public class Lesson04_Screenshot {
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);
        WebDriverWait wait = new WebDriverWait(appiumDriver, 1);

        try {
            MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtn.click();

            // Get whole screen or element
            MobileElement loginScreen = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            wait.until(ExpectedConditions.visibilityOf(loginScreen));
            MobileElement loginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            // screenshot class
            File base64screenshot = loginBtn.getScreenshotAs(OutputType.FILE);

            // file location
            String fileLocation = System.getProperty("user.dir").concat("/screenshot/").concat("LoginButton.png");

            // export into file
            FileUtils.copyFile(base64screenshot, new File(fileLocation));

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}

