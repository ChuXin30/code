package leetcode101.c05;

public class BubbleSort {
    static  void bubble_sort(int[] nums , int n){
        boolean swqpped;
        for (int i = 0 ; i < n ; i++){
//            swqpped = false;
            for (int j = 1 ; j < n - i  ; ++j){
                if(nums[j] < nums[j-1]){
                    int t = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = t;
//                    swqpped = true;
                }
            }
//            if(!swqpped)break;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        BubbleSort.bubble_sort(nums , nums.length);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }
}
