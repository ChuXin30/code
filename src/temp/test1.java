package temp;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] num = new int[n+1];
            num[1] = 1;
            num[2] = 1;
            num[3] = 2;
            for (int i = 4 ; i <= n ; i++){
                num[i] = num[i-1] + num[i-2];
            }
            System.out.println(num[n]);
        }
    }
}
