package coreJava.p06.clone;


import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hiteDay;


    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.hiteDay = (Date) hiteDay.clone();
        return cloned;
    }

    public Employee(String name , double salary ){
        this.name = name;
        this.salary = salary;
        hiteDay = new Date();
    }

    public void setHiteDay(int year , int m , int d) {
        hiteDay.setTime(new GregorianCalendar(year , m , d).getTime().getTime() );
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHiteDay() {
        return hiteDay;
    }


    public void raiseSalary(double byPercent){
        salary += salary*byPercent/100;
    }





    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hiteDay=" + hiteDay +
                '}';
    }
}
