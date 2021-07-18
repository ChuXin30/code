package codetop;

public class t912_quicksort {
    void quick_sort(int[] nums , int start , int end){
        if(start >= end)return;
        int p = partition(nums , start ,end);
        quick_sort(nums, start , p-1 );
        quick_sort(nums , p+1 , end);
    }

    int partition(int[] nums , int start , int end){
        int provt = nums[start];
        int left = start + 1;
        int right = end;
        while (  left < right){
            while (left < right && provt >= nums[left])left++;
            while (left < right && provt <= nums[right])right--;
            if(left < right){
                swap(nums , left , right);
                left++;
                right--;
            }
        }
        if(left == right && provt< nums[right])right--;
        swap(nums, start ,right);
        return right;
    }

    void swap(int[] nums , int left , int right){
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    public int[] sortArray(int[] nums) {
        quick_sort(nums , 0 , nums.length-1);
        return nums;
    }
}
