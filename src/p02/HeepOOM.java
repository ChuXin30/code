package p02;

import java.util.ArrayList;

public class HeepOOM {
    static  class OOMobject{
        long[] l = new long[1000];
    }
    public static void main(String[] args) {
        ArrayList<OOMobject> list = new ArrayList<OOMobject>();
        while (true){
            list.add(new OOMobject());
        }
    }
}
//    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        at JVM.p02.HeepOOM$OOMobject.<init>(HeepOOM.java:7)
//        at JVM.p02.HeepOOM.main(HeepOOM.java:12)