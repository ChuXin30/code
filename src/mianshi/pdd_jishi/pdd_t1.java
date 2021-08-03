package mianshi.pdd_jishi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class pdd_t1 {
    static class xian{
        int start;
        int end;
        public xian(int start , int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            xian[] nums = new xian[n];
            for (int i = 0 ; i < n ; i++){
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                nums[i] = new xian(s , e);
            }

            Arrays.sort(nums, new Comparator<xian>() {
                @Override
                public int compare(xian a, xian b) {
                    if(a.start != b.start){
                        return a.start - b.start;
                    }else {
                        return a.end - b.end;
                    }
                }
            });
            boolean flag = true;
            for (int i = 1 ; i < n ; i++ ){
                if(nums[i].end <= nums[i-1].end ) {
                    System.out.println("true");
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("false");
            }


        }
    }
}
