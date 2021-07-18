package p02;

public class JavaVMstaciSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMstaciSOF oom = new JavaVMstaciSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println(oom.stackLength);
            throw e;
        }
    }
}
//19517
//        Exception in thread "main" java.lang.StackOverflowError
//        at JVM.p02.JavaVMstaciSOF.stackLeak(JavaVMstaciSOF.java:7)