package models.components.Forms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.SwipeEx;

import java.util.List;

public class FormsComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final By inputFieldSel = MobileBy.AccessibilityId("text-input");
    private final By resultInputSel = MobileBy.AccessibilityId("input-text-result");
    private final By switchBtnSel = MobileBy.AccessibilityId("switch");
    private final By dropdownBtnSel = MobileBy.AccessibilityId("Dropdown");
    private final By dropdownListSel = MobileBy.id("android:id/text1");
    private final By activeBtnSel = MobileBy.AccessibilityId("button-Active");
    private final By inActiveBtnSel = MobileBy.AccessibilityId("button-Inactive");
    private final By popupSel = MobileBy.id("android:id/button1");


    public FormsComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputField() {
        MobileElement inputFieldEle = appiumDriver.findElement(inputFieldSel);
        inputFieldEle.clear();
        inputFieldEle.sendKeys("alo123");
    }

    public String getInput() {
        return appiumDriver.findElement(inputFieldSel).getText();
    }

    public String getResultInput() {
        return appiumDriver.findElement(resultInputSel).getText();
    }

    public void clickSwitchBtn() {
        appiumDriver.findElement(switchBtnSel).click();
    }

    public void swipeUp() {
        SwipeEx swipeEx = new SwipeEx(appiumDriver);
        swipeEx.swipeUp();
    }

    public void clickDropDown() {
        appiumDriver.findElement(dropdownBtnSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownListSel));
        List<MobileElement> dropdownELes = appiumDriver.findElements(MobileBy.id("android:id/text1"));
        int WebDriverIOIsAwesome = 1;
        int AppiumIsAwesome = 2;
        int ThisAppIsAwesome = 3;
        dropdownELes.get(ThisAppIsAwesome).click();
    }

    public void clickActiveBtn() {
        MobileElement activeBtn = appiumDriver.findElement(activeBtnSel);
        if (!activeBtn.isEnabled()) {
            Assert.fail("[ERR] click button is not enable!!!");
        }
        activeBtn.click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupSel));
        appiumDriver.findElement(popupSel).click();
    }

    public void clickInactiveBtn() {
        MobileElement inactiveBtn = appiumDriver.findElement(inActiveBtnSel);
        if (!inactiveBtn.isEnabled()) {
            Assert.fail("[ERR] click button is not enable!!!");
        }
        appiumDriver.findElement(inActiveBtnSel).click();
    }
}
