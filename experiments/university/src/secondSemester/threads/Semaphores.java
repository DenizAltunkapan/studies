package secondSemester.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Semaphores {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(5);
        ExecutorService ex = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            ex.execute(()->{
                System.out.println(Thread.currentThread().getName()+ " trying to access");
                try {
                    sem.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" "+ sem.availablePermits());
            });
        }
    }
}

