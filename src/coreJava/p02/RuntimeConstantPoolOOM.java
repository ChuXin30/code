package coreJava.p02;

import java.util.HashSet;
import java.util.Set;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        long i = 0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
//-XX:PermSize=6M -XX:MaxPermSize=6M