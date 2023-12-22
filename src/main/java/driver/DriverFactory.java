package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;
import support.MobileCapabilityTypeEx;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {
    private AppiumDriver<MobileElement> appiumDriver;

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
            case android -> appiumDriver = new AndroidDriver<>(desiredCap);
            case ios -> appiumDriver = new IOSDriver<>(desiredCap);
        }

        appiumDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        return appiumDriver;
    }

    public AppiumDriver<MobileElement> getDriver(Platform platform, String udid, String systemPort, String platformVersion) {

        String remoteInfoViaEnvVar = System.getenv("remote");
        String remoteInfoViaCommandVar = System.getProperty("remote");
        String isRemote = remoteInfoViaEnvVar == null ? remoteInfoViaCommandVar : remoteInfoViaEnvVar;

        if (isRemote == null) {
            throw new IllegalArgumentException("[ERR] please provide env variable [remote]");
        }

        String targetServer = "http://192.168.1.140:4444/wd/hub";
        if (isRemote.equals("true")) {
            String hubIPAdd = System.getenv("hub");
            if (hubIPAdd == null) System.getProperty("hub");
            if (hubIPAdd == null) {
                throw new IllegalArgumentException("[ERR] please provide hub ip address via env variable [hub]");
            }
            targetServer = hubIPAdd + ":4444/wd/hub";
        }

        if (appiumDriver == null) {
            URL appiumServer = null;

            try {
                appiumServer = new URL(targetServer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (appiumServer == null) {
                throw new RuntimeException("Cannot connect to selenium grid");
            }
            DesiredCapabilities desiredCap = new DesiredCapabilities();
            desiredCap.setCapability(PLATFORM_NAME, platform);

            switch (platform) {
                case android:
                    desiredCap.setCapability(AUTOMATION_NAME, "uiautomator2");
                    desiredCap.setCapability(UDID, udid);
                    desiredCap.setCapability(APP_PACKAGE, "com.wdiodemoapp");
                    desiredCap.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
                    desiredCap.setCapability(SYSTEM_PORT, systemPort);
                    appiumDriver = new AndroidDriver<>(appiumServer, desiredCap);
                    break;
                case ios:
                    desiredCap.setCapability(AUTOMATION_NAME, "XCUITest");
                    desiredCap.setCapability(DEVICE_NAME, udid);
                    desiredCap.setCapability(PLATFORM_VERSION, platformVersion);
                    desiredCap.setCapability(BUNDLE_ID, "org.wdioNativeDemoApp");
                    desiredCap.setCapability(WDA_LOCAL_PORT, systemPort);
                    appiumDriver = new IOSDriver<>(appiumServer, desiredCap);
            }
            appiumDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        }
        return appiumDriver;
    }

    public void quitAppium() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
