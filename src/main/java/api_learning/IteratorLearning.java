package api_learning;

import org.testng.Assert;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorLearning {
    public static void main(String[] args) {
        List<String> expected = Arrays.asList("dota","mu","lol");
        List<String> actual = Arrays.asList("dota","mu","lol","rok");

        Iterator<String> actualIterator =  actual.iterator();
        for (String i : expected) {
            Assert.assertEquals(i,actualIterator.next());
        }
    }
}
