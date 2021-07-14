package acm;

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int sum = 0;
            while ( n>0 ){
                sum += n & 0x1;
                n = n >> 1;
            }
            System.out.println(sum);
        }
    }
}
