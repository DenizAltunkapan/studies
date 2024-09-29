package secondSemester.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(5);

        //task to run after 10sec delay
        ex.schedule(()-> {
            System.out.println(Thread.currentThread().getName() + " doing this after 10sec");
        },10, TimeUnit.SECONDS);

        //task to run repeatedly every 15sec
        ex.scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName() + " doing this every 15sec");
        },10,10,TimeUnit.SECONDS);

        //task to run repeatedly 20sec after previous task completes
        ex.scheduleWithFixedDelay(()->{
            System.out.println(Thread.currentThread().getName() + " doing this 20sec since the last time");
        },10,20,TimeUnit.SECONDS);
    }
}
