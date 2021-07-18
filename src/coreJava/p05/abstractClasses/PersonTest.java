package coreJava.p05.abstractClasses;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Employee("harry" , 50000 , 1987 , 10 , 1);
        people[1] = new Student("morris" ,"cs");
        for (Person p : people){
            System.out.println(p.getDescription());
        }
    }
}
