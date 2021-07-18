package coreJava.p05.equals;

import java.util.Objects;

public class Manager extends Employee {
    private double bouns;

    public Manager(String name , double salary , int year , int month , int day){
        super( name ,  salary ,  year ,  month ,  day);
        bouns = 0;
    }

    @Override
    public double getSalary() {
        return bouns+super.getSalary();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bouns=" + bouns + " salery"+getSalary()+
                '}';
    }

    public double getBouns() {
        return bouns;
    }

    @Override
    public boolean equals(Object o) {

        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.bouns, bouns) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bouns);
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }
}
