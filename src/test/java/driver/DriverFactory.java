package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {

    public static AppiumDriver<MobileElement> getDriver(Platform platform) {
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCap = new DesiredCapabilities();
        desiredCap.setCapability(PLATFORM_NAME, "Android");
        desiredCap.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCap.setCapability(UDID, "emulator-5554");
        desiredCap.setCapability(APP_PACKAGE, "com.wdiodemoapp");
        desiredCap.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        URL appiumServer = null;

        try {
            appiumServer = new URL("http://localhost:4723/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (appiumServer == null) {
            throw new RuntimeException("[ERR] cant construct the appium server " + appiumServer);
        }

        switch (platform) {
            case ANDROID -> appiumDriver = new AndroidDriver<>(desiredCap);
            case IOS -> appiumDriver = new IOSDriver<>(desiredCap);
        }

        appiumDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        return appiumDriver;
    }
}
