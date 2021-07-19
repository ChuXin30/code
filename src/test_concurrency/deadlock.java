package test_concurrency;

public class deadlock {
    private static String a = "a";
    private static String b = "b";

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            synchronized (a){
                try {
                    System.out.println(Thread.currentThread().getName() +"获取到了a对象" );
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() +"获取到了b对象" );
                }

            }
        }
    }

    static class Thread2 implements Runnable{
        @Override
        public void run() {
            synchronized (b){
                try {
                    System.out.println(Thread.currentThread().getName() +"获取到了b对象" );
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() +"获取到了a对象" );
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
    }

}
