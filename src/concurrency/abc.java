package concurrency;

public class abc {

    public static void main(String[] args) {
        Thread t1 = new Thread(new work(null));
        Thread t2 = new Thread(new work(t1));
        Thread t3 = new Thread(new work(t2));
        t1.start();
        t2.start();
        t3.start();
    }

}

class work implements Runnable {
    private Thread beforeThread;
    public work(Thread t){
        beforeThread = t;
    }

    @Override
    public void run() {
        if(beforeThread != null){
            try {
                beforeThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }else {
            System.out.println(Thread.currentThread().getName());
        }
    }
}