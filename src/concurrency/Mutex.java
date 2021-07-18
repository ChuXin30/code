package concurrency;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

public class Mutex {
    //静态内部类 自定义同步器
    private static class Sync extends AbstractQueuedLongSynchronizer{
        protected boolean isHeldExclusively(){
            return getState() == 1 ;
        }

    }
}
