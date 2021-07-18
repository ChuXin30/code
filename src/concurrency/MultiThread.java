package concurrency;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for(ThreadInfo threadInfo : threadMXBean.dumpAllThreads(false , false) ){
            System.out.println(threadInfo.getThreadId() + "  " + threadInfo.getThreadName());
        }
    }
}
