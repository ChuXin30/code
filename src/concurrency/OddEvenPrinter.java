package concurrency;

public class OddEvenPrinter {
//    static Object lock = new Object();
//    static volatile int flag = 0;
//
//
//    static class Thread3 implements Runnable{
//        private int target ;
//
//        public Thread3(int target){
//            this.target = target;
//        }
//
//        @Override
//        public void run() {
//            synchronized (lock){
//                for(int i = 0 ; i < 10 ; i++){
//                    while (flag%2  !=  target){
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.println(flag);
//                    flag ++;
//                    lock.notifyAll();
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Thread thread1 = new Thread(new  Thread3(0) ,"threadodd" );
//        Thread thread2 = new Thread(new  Thread3(1) ,"threadeven"  );
//
//
//        thread1.start();
//        thread2.start();
//    }
private Object monitor = new Object();
    private final int limit;
    private volatile int count;

    OddEvenPrinter(int initCount, int times) {
        this.count = initCount;
        this.limit = times;
    }

    public static void main(String[] args) {

        OddEvenPrinter printer = new OddEvenPrinter(0, 10);
        new Thread(printer::print, "odd").start();
        new Thread(printer::print, "even").start();
    }

    private void print() {
        synchronized (monitor) {
            while (count < limit) {
                try {
                    System.out.println(String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count));
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //防止有子线程被阻塞未被唤醒，导致主线程不退出
//            monitor.notifyAll();
        }
    }
}
