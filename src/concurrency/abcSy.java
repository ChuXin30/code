package concurrency;



public class abcSy {
    static Object lock = new Object();
    static volatile int flag = 0;

    static class Thread3 implements Runnable{
       private int target ;

        public Thread3(int target){
            this.target = target;
        }
        @Override
        public void run() {
            synchronized (lock){
                for(int i = 0 ; i < 10 ; i++){
                    while (flag%3  !=  target){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName());
                    flag ++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread3(0) ,"thread1" );
        Thread thread2 = new Thread(new Thread3(1) ,"thread2"  );
        Thread thread3 = new Thread(new Thread3(2) , "thread3" );


        thread3.start();
        thread1.start();
        thread2.start();
    }

}
