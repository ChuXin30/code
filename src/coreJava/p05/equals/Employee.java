package coreJava.p05.equals;

import coreJava.p05.abstractClasses.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Employee  {
    private String name;
    private double salary;
    private LocalDate hiteDay;

    public Employee(String name , double salary , int year , int month , int day){
        this.name = name;
        this.salary = salary;
        hiteDay = LocalDate.of(year , month , day);
    }


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHiteDay() {
        return hiteDay;
    }


    public void raiseSalary(double byPercent){
        salary += salary*byPercent/100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(hiteDay, employee.hiteDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hiteDay);
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
