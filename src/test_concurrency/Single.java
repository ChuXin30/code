package test_concurrency;

import java.util.concurrent.Semaphore;

public class Single {
}

/*
1、懒汉式，线程不安全
是否 Lazy 初始化：是
是否多线程安全：否
实现难度：易
描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
*/

class Singleton1{
    private static Singleton1 singleton1;
    private Singleton1(){}

    public static Singleton1 getSingleton1(){
        if(singleton1 == null)return new Singleton1();
        else return singleton1;
    }
}

/*
2、懒汉式，线程安全
是否 Lazy 初始化：是
是否多线程安全：是
实现难度：易
描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
优点：第一次调用才初始化，避免内存浪费。
缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
*/


class Singleton2{
    private static Singleton2 instance2;
    private Singleton2(){}

    public static synchronized Singleton2 getSingleton2(){
        if(instance2 == null){
            instance2 = new Singleton2();
        }
        return instance2;
    }
}


/*
3、饿汉式
是否 Lazy 初始化：否
是否多线程安全：是
实现难度：易
描述：这种方式比较常用，但容易产生垃圾对象。
优点：没有加锁，执行效率会提高。
缺点：类加载时就初始化，浪费内存。
它基于 classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
*/

 class Singelton3{
    private static Singelton3 instance3 = new Singelton3();
    private Singelton3() {}
    public static Singelton3 getInstance(){
        return instance3;
    }
}

/*
4、双检锁/双重校验锁（DCL，即 double-checked locking）
JDK 版本：JDK1.5 起
是否 Lazy 初始化：是
是否多线程安全：是
实现难度：较复杂
描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
getInstance() 的性能对应用程序很关键。
*/

class Singleton4{
    private volatile static Singleton4 instance4;
    private Singleton4(){}
    public static Singleton4 getInstance(){
        if(instance4 == null){
            synchronized (Singleton4.class){
                instance4 = new Singleton4();
            }
        }
        return instance4;
    }
}






