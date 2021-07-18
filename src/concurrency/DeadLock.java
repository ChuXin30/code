package concurrency;

public class DeadLock {
    private static String A = "a";
    private static String B = "b";

    public static void main(String[] args) {
        new DeadLock().deadLock();
    }

    private void deadLock(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("1");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}
