package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import platform.Lesson02_Platform;

import java.util.List;

public class Lesson03_XpathLearning {
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

        try {
            MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtn.click();

            List<MobileElement> credFieldEle = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USER_NAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;

            credFieldEle.get(USER_NAME_INDEX).sendKeys("teo@sth.com");
            credFieldEle.get(PASSWORD_INDEX).sendKeys("12345678");

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
