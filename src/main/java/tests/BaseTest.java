package tests;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.annotations.*;
import platform.Platform;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BaseTest {
    private static final List<DriverFactory> threadDriverPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;

    private String udid;
    private String systemPort;
    private String platformName;
    private String platformVersion;

    public AppiumDriver<MobileElement> getDriver() {
        return driverThread.get().getDriver(Platform.valueOf(platformName), udid, systemPort, platformVersion);
    }

    @BeforeTest
    @Parameters({"udid", "systemPort", "platformName", "platformVersion"})
    public void initAppiumSession(String udid, String systemPort, String platformName,
                                  @Optional("platformVersion") String platformVersion) {
        this.udid = udid;
        this.systemPort = systemPort;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory driverThread = new DriverFactory();
            threadDriverPool.add(driverThread);
            return driverThread;
        });
    }

    @AfterTest(alwaysRun = true)
    public void quitAppiumSession() {
        driverThread.get().quitAppium();
    }


    @AfterMethod(description = "Taking screenshot if test fail")
    public void takeScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Get method name
            String methodName = result.getName();

            //Get taken time
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DATE);
            int h = calendar.get(Calendar.HOUR);
            int min = calendar.get(Calendar.MINUTE);
            int s = calendar.get(Calendar.SECOND);

            String takenTime = y + " " + m + " " + d + " " + h + " " + min + " " + s;

            // File location to save
            String fileName = methodName + takenTime + ".png";
            String fileLocation = System.getProperty("user.dir") + "/screenshot/" + fileName;

            // Save then attach to Allure report
            try {
                File screenshotBase64 = getDriver().getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshotBase64, new File(fileLocation));
                Path screenshotContentPath = Paths.get(fileLocation);
                InputStream inputStream = Files.newInputStream(screenshotContentPath);
                Allure.attachment(methodName, inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
