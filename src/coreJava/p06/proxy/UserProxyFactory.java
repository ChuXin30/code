package coreJava.p06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxyFactory {
    private Object target;
    public UserProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("----------start-------------");
                Object ret = method.invoke(target , args);
                return null;
            }
        };

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces() , invocationHandler);

    }


}
