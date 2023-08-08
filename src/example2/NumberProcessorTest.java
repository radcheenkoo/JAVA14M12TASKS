package example2;

import java.util.ArrayList;
import java.util.List;

public class NumberProcessorTest {
    public void filterNum() {
        NumberProcessor npFizz = new NumberProcessor((n) -> {
            if (n % 3 == 0) {
                System.out.println("FIZZ");
            }
        });

        NumberProcessor npBuzz = new NumberProcessor((n) -> {
            if (n % 5 == 0) {
                System.out.println("Buzz");
            }
        });

        NumberProcessor npFizzBuzz = new NumberProcessor((n) -> {
            if (n % 5 == 0 && n % 3 == 0) {
                System.out.println("Fizz Buzz");
            }
        });

        NumberProcessor npNotFizzBAzz = new NumberProcessor((n) -> {
            if (n % 5 != 0 && n % 3 != 0) {
                System.out.println(n);
            }
        });

        List<NumberProcessor> threads = new ArrayList<>();
        threads.add(npBuzz);
        threads.add(npFizz);
        threads.add(npFizzBuzz);
        threads.add(npNotFizzBAzz);

        for (NumberProcessor t : threads) {
            t.start();
        }

        for (int i = 0; i < 100; i++) {
            for (NumberProcessor t : threads) {
                t.process(i);
            }

            while (true) {
                int processed = 0;
                for (NumberProcessor t : threads) {
                    if (t.isNProcessed()) {
                        processed++;
                    }
                }
                if (processed == 4) {
                    break;
                }
            }
        }
    }
}
