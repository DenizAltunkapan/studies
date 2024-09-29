package secondSemester.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    public static void main(String[] args) throws InterruptedException {
        Lock mylock = new ReentrantLock();
        Thread thread1 = new Thread(()->{
            System.out.println("Thread 1 trying to lock");
            mylock.lock();
            //doing sth
            //mylock.unlock();
            System.out.println("Thread 1 locked.");
        });
        Thread thread2 = new Thread(()->{
            System.out.println("Thread 2 trying to lock: "+ mylock.tryLock());
            mylock.lock();
            System.out.println("Thread 2 locked");
        });

        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}
