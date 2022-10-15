package codetop;

import java.util.Arrays;
import java.util.HashMap;

public class t1 {


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> hashMap = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{ hashMap.get(target-nums[i]) , i};
            }
            hashMap.put(nums[i] , i);
        }
        return new int[0];


//        Arrays.sort(nums);
//        int n = nums.length - 1;
//        for(int i = 0 ; i < nums.length ; i++ ){
//            int right = n-1;
//            if(nums[i] + nums[right] < target)continue;
//            else {
//                while (right > i){
//                    if(  nums[right] + nums[i] == target)return new int[2]{i , right};
//                    else if(  )
//                }
//            }
//        }
    }

    public static void main(String[] args) {

    }
}
