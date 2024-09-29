package secondSemester.threads;

public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        Caller myCaller = new Caller();
        Thread thr= new Thread(myCaller);
        thr.start();
        Thread.sleep(1000);
        synchronized (myCaller){
            myCaller.notify();
            System.out.println("you have to wait");
            Thread.sleep(20000);
        }

    }
}

class Caller implements Runnable {
    public synchronized void run(){
        System.out.println(Thread.currentThread().getName()+ " calling...");
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("call received!");
    }
//    public synchronized void receive(){
//        notify();
//    }
}
