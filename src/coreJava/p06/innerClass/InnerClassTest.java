package coreJava.p06.innerClass;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock t1 = new TalkingClock(1000 , true);
        t1.start();
        JOptionPane.showMessageDialog(null,"QUIT?");
        System.exit(0);
    }
}


class TalkingClock{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval , boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        TimePrinter timePrinter = new TimePrinter();
        Timer timer = new Timer(interval , timePrinter);
        timer.start();
    }

    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("at the tone the time is "+ Instant.ofEpochMilli(e.getWhen()));
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }

}