package coreJava.p06.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

public class LambdaTest {
    public static void main(String[] args) {
        String[] plants = new String[]{  "Mercury" , "venus" , " earth" , "mars"};
        System.out.println(Arrays.toString(plants));
        Arrays.sort(plants);
        System.out.println(Arrays.toString(plants));
        Arrays.sort(plants , (a , b)-> a.length() - b.length() );
        System.out.println(Arrays.toString(plants));

        Timer timer = new Timer(1000, e -> System.out.println("time is "+new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null , "quit?");
        System.exit(0);

    }
}
