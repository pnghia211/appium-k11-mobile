package api_learning;

import driver.Lesson02_DriverFactory;
import support.Lesson02_MobileCapabilityTypeEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.internal.CapabilityHelpers;
import org.openqa.selenium.Capabilities;
import platform.Lesson02_Platform;

public class HandleVariantBehaviour implements Lesson02_MobileCapabilityTypeEx {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

        try {
            Capabilities caps = appiumDriver.getCapabilities();
            String platform = CapabilityHelpers.getCapability(caps, PLATFORM_NAME, String.class);
            System.out.println(platform);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


