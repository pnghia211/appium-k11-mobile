package tests.parallel;

import org.testng.annotations.Test;
import test_flows.authen.FormsFlow;
import tests.BaseTest;
import tests_data.models.LoginData;

public class FillForms extends BaseTest {

    @Test
    public void testForms() {
        FormsFlow formsFlow = new FormsFlow(getDriver());
        formsFlow.goToFormScreen();
        formsFlow.inputField();
        formsFlow.verifyInput();
        formsFlow.swipeUp();
        formsFlow.clickSwitchBtn();
        formsFlow.clickDropDown();
        formsFlow.clickActiveBtn();
        System.out.println("Session ID : " + getDriver().getSessionId());
    }

}
