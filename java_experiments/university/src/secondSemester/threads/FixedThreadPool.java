package secondSemester.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 11; i++) {
            int j=i;
            ex.execute(()->System.out.println("Thread "+Thread.currentThread().getName()+ " doing its task "+ j));
        }
        ex.shutdown();
    }
}


