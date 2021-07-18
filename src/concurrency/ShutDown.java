package concurrency;

import java.util.concurrent.TimeUnit;

public class ShutDown {
    static class Runer implements Runnable{
//        private volatile boolean on = true;
        private  boolean on = true;

        private long i = 0;
        @Override
        public void run() {
            while ( on && ! Thread.currentThread().isInterrupted() ){
                i++;
            }
            System.out.println( Thread.currentThread().getName()+"\t"+ i);
        }

        public void stop(){
            on = false;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Runer runer1 = new Runer();
        Thread thread = new Thread(runer1 , "countThread1");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

        Runer runer2 = new Runer();
        thread = new Thread(runer2 , "countThread2");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        runer2.stop();


    }
}
