package ThreadLearning;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(()->
                    System.out.println("Back to thread"));
            System.out.println("Back to main");


        }
    }
}
