package p02;

public class JavaVMstacjOOM {
    private void dontStop(){
        while (true){

        }
    }
    public void stackleak(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMstacjOOM javaVMstacjOOM = new JavaVMstacjOOM();
        javaVMstacjOOM.stackleak();
    }
}
