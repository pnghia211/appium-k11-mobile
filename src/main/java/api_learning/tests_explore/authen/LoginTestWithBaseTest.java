package api_learning.tests_explore.authen;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_flows.authen.LoginFlow;
import tests.BaseTest;
import tests_data.authen.DataObjectBuilder;
import tests_data.models.LoginData;

public class LoginTestWithBaseTest extends BaseTest {

    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginData loginData) {
        LoginFlow loginFlow = new LoginFlow(getDriver(), loginData.getEmail(), loginData.getPassword());
        loginFlow.goToLoginScreen();
        loginFlow.login();
        loginFlow.verifyLogin();
    }

    @DataProvider
    public LoginData[] loginCredData() {
        String filePath = "/src/main/java/tests_data/LoginData.json";
        return DataObjectBuilder.buildObjectData(filePath, LoginData[].class);
    }
}
