package api_learning.tests_explore.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import platform.Platform;
import test_flows.authen.LoginFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {

    @Test
    public static void testLogin() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);
//        Map<String, String> loginMap = new HashMap<>();
        List<loginData> loginDataList = new ArrayList<>();
        loginDataList.add(new loginData("teo@","12345678"));
        loginDataList.add(new loginData("teo@sth.com","1234567"));
        loginDataList.add(new loginData("teo@sth.com","12345678"));

        try {
            for (loginData loginData : loginDataList) {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, loginData.getEmail(), loginData.getPassword());
                loginFlow.goToLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
            }

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
}
