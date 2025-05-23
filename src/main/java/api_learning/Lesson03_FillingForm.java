package api_learning;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Lesson02_Platform;
import support.SwipeEx;

import java.util.List;

public class Lesson03_FillingForm {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

        MobileElement navLoginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
        navLoginBtn.click();

        MobileElement inputFieldEle = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
        MobileElement inputResultFieldEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-text-result"));
        inputFieldEle.sendKeys("Type something here 123");

        if(inputFieldEle.getText().equals(inputResultFieldEle.getText())) {
            System.out.println("Input and result input have been matched");
        } else System.out.println("Input and result input not been matched");


        MobileElement switchBtn = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
        switchBtn.click();

        SwipeEx swipe = new SwipeEx(appiumDriver);
        swipe.swipeUp();

        MobileElement dropdownBtn = appiumDriver
                .findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"icon_container\")"));
        dropdownBtn.click();

        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        MobileElement dropdownListEle = appiumDriver.findElement(MobileBy.id("com.wdiodemoapp:id/select_dialog_listview"));

        wait.until(ExpectedConditions.visibilityOf(dropdownListEle));

        List<MobileElement> dropdownList = appiumDriver
                .findElements(MobileBy.id("android:id/text1"));
        dropdownList.get(3).click();

        MobileElement activeBtn = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));
        activeBtn.click();
        MobileElement activePopUp = appiumDriver.findElement(MobileBy.id("android:id/parentPanel"));
        wait.until(ExpectedConditions.visibilityOf(activePopUp));
        MobileElement askMeLaterBtn = appiumDriver.findElement(MobileBy
                .AndroidUIAutomator("new UiSelector().resourceId(\"android:id/button3\")"));
        askMeLaterBtn.click();

    }
}
