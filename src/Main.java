import example2.NumberProcessorTest;
import example2WithExecutorService.NumberFilter;

import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        //example1Test();
        //example2Test();
        example2TestWithExecutorService();
    }

    public static void example1Test(){
        Example1 example1 = new Example1();
        example1.countTheTime();
    }
    public static void example2Test(){
        NumberProcessorTest numberProcessorTest = new NumberProcessorTest();
        numberProcessorTest.filterNum();
    }
    public static void example2TestWithExecutorService(){
        NumberFilter numberFilter = new NumberFilter(100);
        numberFilter.filterNumber();
        numberFilter.closeMethod();
    }
}