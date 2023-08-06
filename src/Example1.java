import java.sql.SQLOutput;

public class Example1 {
    public void countTheTime(){
        long startT = System.currentTimeMillis();

        Thread time1Second = new Thread(()->{

            long currentTime = System.currentTimeMillis();
            long seconds = (currentTime - startT) / 1000;

            while (true) {

                System.out.println("Пройшло " + seconds + " секунд");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                seconds += 1;
            }
        });

        Thread time2Second = new Thread(() ->{
            long count = 0;
           while(true){
               if (count != 0) {
                   System.out.println("Минуло 5 секунд");
               }
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               count += 1;
           }
        });

        time1Second.start();
        time2Second.start();
    }

}
