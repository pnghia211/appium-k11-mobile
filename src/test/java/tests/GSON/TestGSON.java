package tests.GSON;

import com.google.gson.Gson;
import tests_data.models.LoginData;

import java.util.HashMap;
import java.util.Map;

public class TestGSON {
    public static void main(String[] args) {
        LoginData loginData = new LoginData("teo@sth.com", "12345678");
        Gson gson = new Gson();
        System.out.println(gson.toJson(loginData));

        String JSONData = "{email:ti@sth.com,password:12345678}";
        LoginData convertData = gson.fromJson(JSONData, LoginData.class);
        System.out.println(convertData);
    }
}
