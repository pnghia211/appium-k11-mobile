package api_learning.tests_explore.authen;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import platform.Lesson02_Platform;
import test_flows.authen.LoginFlow;
import tests_data.authen.DataObjectBuilder;
import tests_data.models.LoginData;

public class LoginTestWithDataBuilder {

    @Test(dataProvider = "loginCredData")
    public static void testLogin(LoginData loginData) {
        AppiumDriver<MobileElement> appiumDriver = Lesson02_DriverFactory.getDriver(Lesson02_Platform.android);

        try {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, loginData.getEmail(), loginData.getPassword());
                loginFlow.goToLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public LoginData[] loginCredData () {
        String filePath = "/src/main/java/tests_data/LoginData.json";
        return DataObjectBuilder.buildObjectData(filePath,LoginData[].class);
    }
}
