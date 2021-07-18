package coreJava.p01;

public class StaticTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("tom",1000);
        staff[1] = new Employee("dick",2000);
        staff[2] = new Employee("harry",3000);

        for(Employee e : staff){
            e.setId();
            System.out.println(e.toString());
        }

        System.out.println(Employee.getNextId());

    }
}

class Employee{
   private static int nextId = 0;
   private String name;
   private double salary;
   private int id;
   public Employee(String n , double s){
       name = n;
       salary = s;
       id = 0;
   }

   public static int getNextId() {
       return nextId;
   }

   public static void setNextId(int nextId) {
       Employee.nextId = nextId;
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