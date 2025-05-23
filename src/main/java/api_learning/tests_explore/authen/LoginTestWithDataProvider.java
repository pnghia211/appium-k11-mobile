package api_learning.tests_explore.authen;

import driver.Lesson02_DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import platform.Lesson02_Platform;
import test_flows.authen.LoginFlow;

public class LoginTestWithDataProvider {

    @Test(dataProvider = "loginCredData")
    public static void testLogin(loginData loginData) {
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

    public static class loginData {
        String email;
        String password;

        public loginData(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }

    @DataProvider
    public loginData[] loginCredData () {
        loginData loginData01 = new loginData("teo@","12345678");
        loginData loginData02 = new loginData("teo@sth.com","1234567");
        loginData loginData03 = new loginData("teo@sth.com","12345678");
        return new loginData[]{loginData01,loginData02,loginData03};
    }

}
