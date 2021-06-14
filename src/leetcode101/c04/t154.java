package leetcode101.c04;

public class t154 {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            System.out.println("start="+start+"\tend="+end);

            if(nums[start] > nums[end])return nums[end];
            int mid = (end + start)/2;
            if(nums[mid] > nums[end]){
                start = mid  ;
            }else if(nums[mid] < nums[end]){
                end = mid;
            }else {
                end--;
            }
        }
        return nums[end];
    }
}
