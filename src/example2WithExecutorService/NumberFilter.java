package example2WithExecutorService;

import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberFilter {
    private int n;
    private int currentNum = 0;
    private Object object = new Object();
    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    public NumberFilter(int n){
        this.n = n;
    }
    public void filterNumber(){

//        Runnable fizzTask = () -> {
//            for (int i = 0; i < 100; i++) {
//                if (i % 3 == 0) {
//                    System.out.println("FIZZ");
//                }
//            }
//        };
        executorService.submit(()->{
            synchronized (object){
                while(currentNum <= n){
                    if ((currentNum % 3) == 0 && (currentNum % 5) != 0){
                        System.out.println("Fizz");
                        currentNum++;
                        object.notifyAll();
                    }
                    else {
                        try {
                            object.wait();
                        }catch (InterruptedException exception){
                            System.out.println(exception.getMessage());
                        }
                    }
                }
            }
        });

//        Runnable buzzTask = () -> {
//            for (int i = 0; i < 100; i++) {
//                if (i % 5 == 0) {
//                    System.out.println("Buzz");
//                }
//            }
//        };
        executorService.submit(() ->{
            synchronized (object){
                while(currentNum <= n){
                    if ((currentNum % 5) == 0 && (currentNum % 3) != 0){
                        System.out.println("Buzz");
                        currentNum++;
                        object.notifyAll();
                    }
                    else {
                        try {
                            object.wait();
                        }catch (InterruptedException exception){
                            System.out.println(exception.getMessage());
                        }
                    }
                }
            }
        });

//        Runnable fizzBuzzTask = () -> {
//            for (int i = 0; i < 100; i++) {
//                if (i % 5 == 0 && i % 3 == 0) {
//                    System.out.println("Fizz Buzz");
//                }
//            }
//        };
        executorService.submit(() ->{
            synchronized (object){
                while(currentNum <= n){
                    if ((currentNum % 5) == 0 && (currentNum % 3) == 0){
                        System.out.println("Fizz Buzz");
                        currentNum++;
                        object.notifyAll();
                    }
                    else {
                        try {
                            object.wait();
                        }catch (InterruptedException exception){
                            System.out.println(exception.getMessage());
                        }
                    }
                }
            }
        });

//        Runnable notFizzBuzzTask = () -> {
//            for (int i = 0; i < 100; i++) {
//                if (i % 5 != 0 && i % 3 != 0) {
//                    System.out.println(i);
//                }
//            }
//        };
        executorService.submit(() -> {
            synchronized (object){
                while(currentNum <= n){
                    if ((currentNum % 5) != 0 && (currentNum % 3) != 0){
                        System.out.println(currentNum);
                        currentNum++;
                        object.notifyAll();
                    }
                    else {
                        try {
                            object.wait();
                        }catch (InterruptedException exception){
                            System.out.println(exception.getMessage());
                        }
                    }
                }
            }
            executorService.execute(this::filterNumber);
        });
    }
    public void closeMethod(){
        executorService.shutdown();
    }

}
