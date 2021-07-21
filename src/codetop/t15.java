package codetop;

import java.util.*;

public class t15 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;


        for(int i = 0 ; i < n-2 ; i++ ){
            int left = i;
            int right = n-1;
            int mid = i+1;
            if(left > 0 && nums[left] == nums[left -1])continue;
            int targer = -nums[left] ;

            while ( mid < right ){

                if(nums[mid] + nums[right] == targer){
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add( nums[left]  ); t.add(nums[mid]); t.add( nums[right]) ; ;
                    ret.add( t );
                    mid++;
                    right--;
                    while(mid > 0 &&  nums[mid] == nums[mid-1]  )mid++;
                    while(right < n-1 &&  nums[right] == nums[right+1]  )right--;
                }else if(nums[mid] + nums[right] > targer ){
                    right--;
                }else {
                    mid++;
                }
            }
        }

        return  ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> out =  new t15().threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(out.toString());
    }
}
