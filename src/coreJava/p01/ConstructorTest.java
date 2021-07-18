package coreJava.p01;

import java.util.Random;

public class ConstructorTest {
    public static void main(String[] args) {
        Employee1[] staff = new Employee1[3];
        staff[0] = new Employee1("tom",1000);
        staff[1] = new Employee1("dick",2000);
        staff[2] = new Employee1("harry",3000);

        for(Employee1 e : staff){
            e.setId();
            System.out.println(e.toString());
        }

        System.out.println(Employee.getNextId());

    }
}

class Employee1{
    private static int nextId = 0;
    private String name;
    private double salary;
    private int id;

    static {
        nextId = new Random().nextInt(1000);
    }

    {
        id = nextId;
        nextId++;
    }

    public Employee1(String n , double s){
        name = n;
        salary = s;
        id = 0;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    public void setId() {
        this.id = nextId+1;
        nextId++;
    }
}
