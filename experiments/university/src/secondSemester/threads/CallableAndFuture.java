package secondSemester.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(5);
        List<Future> allFutures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int j=i;
            Future<Integer> val= ex.submit(()->j);
            allFutures.add(val);
        }
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = allFutures.get(i);
            try {
                int result = future.get(0, TimeUnit.MILLISECONDS);
                ex.execute(()->System.out.println(Thread.currentThread().getName()+ ": "+ result));
            } catch (TimeoutException e) {
                System.out.println("couldnt run");
            }
        }

        ex.shutdown();
    }
}
