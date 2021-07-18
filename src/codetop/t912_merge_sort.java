package codetop;

public class t912_merge_sort {
    void mergesort(int[] nums , int start , int end ,int[] temp){
        if(start >= end)return;
        int mid = (start + end)/2;
        mergesort(nums , start , mid ,temp);
        mergesort(nums , mid+1 , end , temp);
        meger(nums , start , end , temp);
    }

    void meger(int[] nums , int start , int end , int[] temp ){
        int mid = (start+end)/2;
        int start1 = start;
        int end1 = mid;
        int start2 = mid+1;
        int end2 = end;
        int index = start;
        while (start1 <= end1 && start2 <= end2){
            if(nums[start1] < nums[start2]){
                temp[index++] = nums[start1++];
            }else {
                temp[index++] = nums[start2++];
            }
        }

        while (start1 < end1){
            temp[index++] = nums[start1++];
        }

        while (start2 < end2){
            temp[index++] = nums[start2++];
        }

        for (int i = start ; i < end ; i++){
            nums[i] = temp[i];
        }

    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        mergesort(nums , 0 , nums.length -1 , temp);
        return nums;
    }
}
