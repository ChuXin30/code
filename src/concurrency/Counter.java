package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        List<Thread> ts = new ArrayList<Thread>();


        for (int k = 0 ; k < 1000 ; k++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0 ; j < 10000 ; j++ ){
                        counter.count1();
                        counter.safecount();
                    }
                }
            });
            ts.add(thread);
        }

        for(Thread t : ts)t.start();

        for (Thread t : ts){
            t.join();
        }

        System.out.println(counter.i);
        System.out.println(counter.atomicInteger.get());

    }

    private void count1() {
        i++;
    }

    private void safecount() {
        for (;;){
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i , ++i);
            if(suc)break;
        }
    }





}
