package concurrency;

public class NumAndLetterPrinter {
    private static char c = 'A';
    private static int num = 0;
    static final Object lock = new Object();

    static class print implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                for (int i = 0 ; i < 26 ; i++){
                    if(Thread.currentThread().getName().equals("num")){
                        System.out.println(Thread.currentThread().getName()+": "+i);
                        num++;
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        System.out.println(Thread.currentThread().getName()+": "+c);
                        c = (char)(c+1);


                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
//                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new print() ,"num");
        Thread thread2 = new Thread(new print() , "letter");
        thread1.start();
        thread2.start();
    }
}
