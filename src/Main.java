import example2.CheckNumberProcessor;

public class Main {
    public static void main(String[] args) {
        //example1Test();
        example2Test();
    }

    public static void example1Test(){
        Example1 example1 = new Example1();
        example1.countTheTime();
    }
    public static void example2Test(){
        CheckNumberProcessor checkNumberProcessor = new CheckNumberProcessor();
        checkNumberProcessor.filterNumber();
    }
}