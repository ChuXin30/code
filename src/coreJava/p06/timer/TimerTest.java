package coreJava.p06.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimerTest {
    public static void main(String[] args) {
        TimePrinter timePrinter = new TimePrinter();
        Timer timer = new Timer(1000 , timePrinter);
        timer.start();
        JOptionPane.showMessageDialog(null , "quit program?");
        System.exit(0);
    }

}

class TimePrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("at the tone , the time is " + Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }

}
