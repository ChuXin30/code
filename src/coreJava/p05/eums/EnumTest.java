package coreJava.p05.eums;

import java.util.Locale;
import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Entry a size:(SMALL , MEDIUM , LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class , input);
        System.out.println("size="+size);
        System.out.println("abbreviation="+size.getAbbreviation());
        if(size == Size.LARGE){
            System.out.println("gggggg");
        }
    }
}

enum Size{
    SMALL("S") , MEDIUM("M") , LARGE("L");
    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }
    private String abbreviation;
    public String getAbbreviation(){
        return abbreviation;
    }
}
