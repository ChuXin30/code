package coreJava.p05.equals;

public class EqualsTest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("alice" , 75000 , 1987 , 12 , 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("alice" , 75000 , 1987 , 12 , 15);
        Employee bob = new Employee("bob" , 50000 , 1987 , 1 , 1);

        System.out.println((alice1 == alice2));
        System.out.println((alice1 == alice3));
        System.out.println(alice1.equals(alice3) );
        System.out.println(alice1.equals(bob));

        System.out.println(bob.toString());

        Manager carl = new Manager("carl" , 80000 , 1987 , 12 , 15);
        Manager boss = new Manager("carl" , 80000 , 1987 , 12 , 15);

        boss.setBouns(5000);
        System.out.println(boss.toString());
        System.out.println(carl.equals(boss));
        System.out.println(alice1.hashCode());
        System.out.println(alice3.hashCode());
        System.out.println(bob.hashCode());
        System.out.println(carl.hashCode());

        /*
        true
        false
        true
        false
        Employee{name='bob', salary=50000.0, hiteDay=1987-01-01}
        Manager{bouns=5000.0 salery85000.0}
        false
        -1491851666
        -1491851666
        -503560427
        -87328773
         */

    }
}
