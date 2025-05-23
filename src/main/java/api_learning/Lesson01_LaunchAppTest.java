package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Lesson01_LaunchAppTest {

    // Send request to Appium server
    public static void main(String[] args) {
        AppiumDriver <MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCapabilities = getDesiredCapabilities();

        // Init appium session
        try {
            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AppiumDriver<>(appiumServer, desiredCapabilities);

            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(appiumDriver != null) {
            appiumDriver.quit();
        }
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName" , "uiautomator2");
        desiredCapabilities.setCapability("udid" , "emulator-5554");
        desiredCapabilities.setCapability("appPackage" , "com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity" , "com.wdiodemoapp.MainActivity");
        return desiredCapabilities;
    }
}
