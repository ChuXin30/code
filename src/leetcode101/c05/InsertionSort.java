package leetcode101.c05;

public class InsertionSort {
    static void insertion_sort(int[] nums, int n){
        for(int i = 0 ; i < n ; i++ ){
            for(int j = i ; j > 0 && nums[j] < nums[j-1] ; --j){
                int t = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        InsertionSort.insertion_sort(nums , nums.length);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }
}
