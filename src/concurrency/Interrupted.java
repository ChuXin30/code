package concurrency;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class Interrupted {
    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread sleept= new Thread(new SleepRunner() , "sleep");
        Thread busyt = new Thread(new BusyRunner()  , "busy");
        sleept.start();
        busyt.start();

        System.err.println("sleep thread interrupted is " + sleept.isInterrupted());
        System.out.println("busy thread interrupted is " + busyt.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
        sleept.interrupt();
        busyt.interrupt();
        System.err.println("sleep thread interrupted is " + sleept.isInterrupted());
        System.out.println("busy thread interrupted is " + busyt.isInterrupted());

        TimeUnit.SECONDS.sleep(1);
    }

}
