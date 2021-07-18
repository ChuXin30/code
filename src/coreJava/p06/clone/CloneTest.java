package coreJava.p06.clone;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee = new Employee("jone" , 50000);
        employee.setHiteDay(1254, 1 , 1);
        Employee copy = employee.clone();


        copy.setHiteDay(1111 , 22 , 1);
        System.out.println(employee.toString());
        System.out.println(copy.toString());

    }
}
