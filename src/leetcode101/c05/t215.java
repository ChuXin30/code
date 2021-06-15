package leetcode101.c05;

//215. 数组中的第K个最大元素
//        在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//        示例 1:
//
//        输入: [3,2,1,5,6,4] 和 k = 2
//        输出: 5
//        示例 2:
//
//        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//        输出: 4

public class t215 {
    public int quickSort(int [] nums , int left , int right , int index){
        if(left > right) return index;
        int p = parition(nums , left , right);
        if( p == index)return nums[index];
        else if(p > index){
            return quickSort(nums , left , p-1 , index);
        }else{
            return quickSort(nums , p+1 , right , index);
        }
    }

    public int parition(int [] nums , int start , int end){
        int p = nums[start];
        int index = start;
        int left = start+1;
        int right = end;
        while(left < right){
            while(left < right && nums[left] < p) left++;
            while(left < right && nums[right] >= p) right--;
            if(left < right){
                swap(nums, left , right);
                left++;
                right--;
            }
        }
        if(right == left && nums[right] > p){
            right--;
        }
        swap(nums,index , right);
        return right;
    }

    public void swap(int[] nums , int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // quickSort(nums, 0 , nums.length-1);
        // return nums[nums.length-k];

        return quickSort(nums, 0 , nums.length -1 , nums.length-k);
    }
}
