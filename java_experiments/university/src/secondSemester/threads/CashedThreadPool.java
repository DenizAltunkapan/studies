package secondSemester.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CashedThreadPool {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < 11; i++) {
            int j=i;
            ex.execute(()->System.out.println("Thread "+Thread.currentThread().getName()+ " doing its task "+ j));
        }
        ex.shutdown();
    }
}
