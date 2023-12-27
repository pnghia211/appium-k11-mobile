package tests.parallel;

import org.testng.annotations.Test;
import test_flows.authen.FormsFlow;
import tests.BaseTest;

public class FormsTest extends BaseTest {

    @Test
    public void testForms() {
        FormsFlow formsFlow = new FormsFlow(getDriver());
        formsFlow.goToFormScreen();
        formsFlow.inputField();
        formsFlow.verifyInput();
        formsFlow.swipeUp();
        formsFlow.clickSwitchBtn();
        formsFlow.clickDropDown();
        formsFlow.clickInactiveBtn();
        formsFlow.clickActiveBtn();
        System.out.println("Session ID : " + getDriver().getSessionId());
    }

}
