package coreJava.p05.abstractClasses;

import java.time.LocalDate;

public class Employee extends Person {

    private double salary;
    private LocalDate hiteDay;

    public Employee(String name , double salary , int year , int month , int day){
        super(name);
        this.salary = salary;
        hiteDay = LocalDate.of(year , month , day);
    }


    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.3f",salary);
    }


}
