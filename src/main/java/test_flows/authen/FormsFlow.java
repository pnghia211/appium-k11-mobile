package test_flows.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.Forms.FormsComponent;
import models.pages.MainScreen;
import org.testng.Assert;
import support.SwipeEx;
import test_flows.BaseFlow;

public class FormsFlow extends BaseFlow {

    public FormsFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void inputField() {
        MainScreen mainScreen = new MainScreen(appiumDriver);
        FormsComponent formsComp = mainScreen.formsComp();
        formsComp.inputField();
    }

    public void verifyInput() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        String actual = formsComp.getInput();
        String result = formsComp.getResultInput();
        Assert.assertEquals(actual,result,"[ERR] actual and result input are different!!!");
    }

    public void clickSwitchBtn() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        formsComp.clickSwitchBtn();
    }

    public void swipeUp() {
        SwipeEx swipeEx = new SwipeEx(appiumDriver);
        swipeEx.swipeUp();
    }

    public void clickDropDown() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        formsComp.clickDropDown();
    }

    public void clickActiveBtn() {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        formsComp.clickActiveBtn();
    }

    public void clickInactiveBtn () {
        FormsComponent formsComp = new FormsComponent(appiumDriver);
        formsComp.clickInactiveBtn();
    }

}
