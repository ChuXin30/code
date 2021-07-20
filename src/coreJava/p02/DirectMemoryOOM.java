package coreJava.p02;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOOM {
    private static final int _1m = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1m);
        }

    }

}
//    Exception in thread "main" java.lang.OutOfMemoryError
//        at sun.misc.Unsafe.allocateMemory(Native Method)
//        at JVM.coreJava.p02.DirectMemoryOOM.main(DirectMemoryOOM.java:16)