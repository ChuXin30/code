package leetcode101.c05;

public class SelectionSort {
    void selection_sort(int[] nums , int n){
        int mid;
        for(int i = 0 ; i < n -1 ; i++){
            mid = i;
            for(int j = i +1 ; j < n ; j++ ){
                if(nums[j] < nums[mid]){
                    mid = j;
                }
            }
            int t = nums[mid];
            nums[mid] = nums[i];
            nums[i] = t;
        }
    }
}
