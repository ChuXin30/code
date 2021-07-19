package test;

import java.util.ArrayList;
import java.util.List;

public class t3 {
    public static int getValue(int rowIndex, int columnIndex) {
        // write code here
        ArrayList<Integer> p = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex; ++i) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(p.get(j - 1) + p.get(j));
                }
            }
            p = cur;
        }
//        System.out.println(p);
        return p.get(columnIndex-1);
    }

    public static void main(String[] args) {
        System.out.println( getValue(4,3));
    }


}
