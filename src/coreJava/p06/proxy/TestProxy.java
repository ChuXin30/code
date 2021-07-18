package coreJava.p06.proxy;

public class TestProxy {
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        target.save();

        IUserDao iUserDao = (IUserDao) new UserProxyFactory(target).getProxyInstance();
        iUserDao.save();
    }
}
