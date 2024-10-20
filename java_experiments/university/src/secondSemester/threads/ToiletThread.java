package secondSemester.threads;

public class ToiletThread implements Runnable{
    String name;
    static Toilet toilet = new Toilet();
    public ToiletThread(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name+ " "+ Thread.currentThread().getName());
        toilet.enter();
        System.out.println(name+ "leaving toilet");
    }

    public synchronized String getName() throws InterruptedException {
        return this.name;
    }
}

class Toilet{
    public synchronized void enter(){

        System.out.println(Thread.currentThread().getName()+ " entering toilet");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Main{
    public static void main(String[] args) {
        Thread one = new Thread(new ToiletThread("one"));
        Thread two = new Thread(new ToiletThread("two"));
        one.start();two.start();

    }
}
