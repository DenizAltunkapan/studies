package secondSemester.threads;

public class volatile_synchronized {

    private volatile boolean running = true;
    public static int counter = 0;

    public static synchronized int add(int a){
        return counter += a;
    }
    public void run() {
        while (running) {
            counter++;
        }
       System.out.println("Thread stopped.");
    }

    public void stop() {
        running = false;
    }

    private static void volatileMethod() throws InterruptedException {
        volatile_synchronized example = new volatile_synchronized();
        Thread thread = new Thread(example::run);
        thread.start();

        Thread.sleep(1000); // Läuft für eine Sekunde
        example.stop();
        thread.join();
    }
    static Object myLock = new Object();
    private static void synchronizedThreads() throws InterruptedException {
        volatile_synchronized obj= new volatile_synchronized();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i <100000; i++) {
                synchronized (myLock) {
                    System.out.println("Thread 1: " + ++counter);
                }
            }
        });

        Thread thread2 = new Thread(()->{
            for (int i = 0; i <100000; i++) {
                synchronized (myLock) {
                    System.out.println("Thread 2: " + ++counter);
                }
            }
        });

        thread2.start();
        thread1.start();
    }

    public static void main(String[] args) throws InterruptedException {
        //volatileMethod();
        synchronizedThreads();
    }
}
