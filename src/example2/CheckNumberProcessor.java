package example2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class CheckNumberProcessor {

    public void filterNumber(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Runnable fizzTask = () -> {
            for (int i = 0; i < 100; i++) {
                if (i % 3 == 0) {
                    System.out.println("FIZZ");
                }
            }
        };

        Runnable buzzTask = () -> {
            for (int i = 0; i < 100; i++) {
                if (i % 5 == 0) {
                    System.out.println("Buzz");
                }
            }
        };

        Runnable fizzBuzzTask = () -> {
            for (int i = 0; i < 100; i++) {
                if (i % 5 == 0 && i % 3 == 0) {
                    System.out.println("Fizz Buzz");
                }
            }
        };

        Runnable notFizzBuzzTask = () -> {
            for (int i = 0; i < 100; i++) {
                if (i % 5 != 0 && i % 3 != 0) {
                    System.out.println(i);
                }
            }
        };

        executorService.execute(fizzTask);
        executorService.execute(buzzTask);
        executorService.execute(fizzBuzzTask);
        executorService.execute(notFizzBuzzTask);

        executorService.shutdown();
    }


}
