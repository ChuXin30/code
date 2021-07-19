package test_concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class abc {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    static class Thread1 implements Runnable{

        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; i++){
                try {
                    A.acquire();
                    System.out.println('A');
                    B.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    static class Thread2 implements Runnable{

        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; i++) {

                try {
                    B.acquire();
                    System.out.println('B');
                    C.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Thread3 implements Runnable{

        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; i++) {
                try {
                    C.acquire();
                    System.out.println('C');
                    A.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        Thread t3 = new Thread(new Thread3());
        t1.start();
        t2.start();
        t3.start();
    }
}

