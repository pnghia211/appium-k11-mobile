package support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verify {
    Map<String, String> assertMap = new HashMap<>();
    List<String> msgErrorList = new ArrayList<>();

    public void verify(String a, String b) {
        if (!a.equals(b)) {
            assertMap.put(a, b);
            msgErrorList.add("[ERR] expected " + a + " but found " + b);
        }
    }

    public void verifyAll() {
        if (!this.assertMap.isEmpty()) {
            for (String key : assertMap.keySet()) {
                System.out.println("Actual :" + key);
                System.out.println("Expected :" + assertMap.get(key));
            }
            throw new AssertionError(msgErrorList);
        }
    }
}
