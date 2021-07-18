package concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();


    static class Wait implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while (flag){
                    System.out.println(Thread.currentThread()+"flag = true wait "+ new SimpleDateFormat("HH:mm:ss").format(new Date())  );
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+"flag = false wait "+ new SimpleDateFormat("HH:mm:ss").format(new Date())  );
            }
        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread()+"hold lock "+ new SimpleDateFormat("HH:mm:ss").format(new Date())  );
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            synchronized (lock){
                System.out.println(Thread.currentThread()+"hold lock again "+ new SimpleDateFormat("HH:mm:ss").format(new Date())  );
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait() , "wait");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread nottiyThread = new Thread(new Notify() , "notify");
        nottiyThread.start();
    }
}
