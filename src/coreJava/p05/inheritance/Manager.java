package coreJava.p05.inheritance;

public class Manager extends Employee{
    private double bouns;

    public Manager(String n , double s){
        super(n , s);
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

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }
}
