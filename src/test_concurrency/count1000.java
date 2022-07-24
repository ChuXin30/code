package test_concurrency;


import java.util.concurrent.atomic.AtomicInteger;

public class count1000 implements Runnable {
    private static AtomicInteger count = new AtomicInteger(0);
    private String name;
    private static int num = 1;

//    public count1000( String name ,int num){
//        this.name = name;
//        this.num = num;
//    }



    public static synchronized void calc(){
        if ( count.get() < 1000 ){
            count.incrementAndGet();
            System.out.println("正在运行是线程" + Thread.currentThread().getName() + ":" + count);
        }
    }



//tsetttttt

    @Override
    public void run() {
        while (true){
            try {
                count1000.calc();
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 6 ; i++){
            Thread mysafeThread = new Thread(new count1000());
            mysafeThread.start();
        }
    }
}

