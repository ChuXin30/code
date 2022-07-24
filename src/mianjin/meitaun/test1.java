package mianjin.meitaun;

import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a = scanner.nextInt();
            int[] nums = new int[n];
            for (int i =  0 ; i < n ; i++ ){
                nums[i] = scanner.nextInt();
            }

            int count  = 0;
            int left = -1, right = 0;
            while (right  < n ){
                while ( right <= n-1 &&  nums[right] >= a)right++;
//                System.out.println("right="+right + " left="+left);
                if((right - left - m) >= 0  ){
                    count += right - left - m  ;
//                    if( right < n ){
//                        count += right - left - m  ;
//                    }else if(right == n && nums[right-1] >= a){
//                        count += right - left - m  ;
//                    }else if(right == n && nums[right-1] < a ){
//                        if( (right -left - m -1) > 0 )count += right - left - m-1;
//                    }
                }
                left = right;
                right++;
            }
            System.out.println(count);
        }
    }
}
