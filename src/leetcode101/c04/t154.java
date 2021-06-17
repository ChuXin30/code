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
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}

