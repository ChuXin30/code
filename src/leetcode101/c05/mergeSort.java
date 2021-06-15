package leetcode101.c05;

public class mergeSort {
    void merge_sort(int[] nums , int l , int r , int[] temp){
        if(l + 1 >= r)return;

        int m = l + ( r - l)/2 ;
        merge_sort(nums , l  , m , temp);
        merge_sort(nums , m , r , temp);
        int p = l , q = m , i = l;
        while (p < m || q < r){
            if(q >= r || (p < m && nums[p] <= nums[q])){
                temp[i++] = nums[p++];
            }else {
                temp[i++] = nums[q++];
            }
        }
        for (i = l ; i < r ; ++i){
            nums[i] = temp[i];
        }
    }




    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        new mergeSort().merge_sort(nums, 0 , nums.length , new int[nums.length]);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }
}
