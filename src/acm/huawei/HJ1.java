package acm.huawei;

import java.util.Scanner;

public class HJ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] bufs = str.split(" ");
            int n = bufs.length;
            System.out.println(bufs[n-1].length());

        }
    }
}
