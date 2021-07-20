package acm.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class HJ3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0 ; i < n ; i ++ ){
                nums[i] = scanner.nextInt();
            }

            Arrays.sort(nums );
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int i = 0 ; i < n ; i ++ ){
                if(!hs.contains(nums[i])) System.out.println(nums[i]);
                hs.add(nums[i]);
            }
        }
    }
}
