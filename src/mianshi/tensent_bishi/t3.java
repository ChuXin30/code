package mianshi.tensent_bishi;

import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        // 01 10 00肯定不删除 11肯定不删除
        // 就是遇到010删除1 101删除0
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String s = scanner.next();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0 ; i < n; i++){
                stringBuffer.append(s.charAt(i));
                if((i+1)<n && s.charAt(i) != s.charAt(i+1)){
                    if( (i+2) < n && s.charAt(i) == s.charAt(i+2) ){
                        i = i+1;
                    }
                }
            }
            int size = stringBuffer.length();



            int count = 0;
            int[] dp = new int[size];
            dp[0]= 1;
            for (int i = 1 ; i < size ; i++ ){
                if(stringBuffer.charAt(i) == stringBuffer.charAt(i-1)){
                    dp[i] = dp[i-1] + 1;
                }else {
                    dp[i] = 1;
                }
            }

            for (int i = 0 ; i < size ; i++ ){
                count += dp[i];
//                System.out.println(dp[i]);
            }


//            System.out.println(stringBuffer.toString());
            System.out.println(count);
        }
    }
}
