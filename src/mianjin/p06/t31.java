package mianjin.p06;

//31. 下一个排列
//        实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//        必须 原地 修改，只允许使用额外常数空间。

/*
从后往前找到第一个升序的对
找到后面第一个比它大的元素，交互，然后反正后面的数组
然后将当前节点到结尾的数组进行翻转（已经是递减的了）
我是进行排序
 */

import java.util.Arrays;

public class t31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1)return;
        int index = n-1;
        for ( ; index > 0 ; index--){
            if(nums[index] > nums[index-1])break;
        }
        int p = index -1;
        int q = index;
        int min = Integer.MAX_VALUE;
        // System.out.print(index);

        if(index == 0){
            Arrays.sort( nums);
            return;
        }

        for (int i = index ; i < n ; i++ ){
            if( (nums[i] - nums[p]) > 0 &&  (nums[i] - nums[p]) < min ){
                min = (nums[i] - nums[p]);
                q = i;
            }
        }

        int t = nums[q];
        nums[q] = nums[p];
        nums[p] = t;

        Arrays.sort( nums , index , n );


    }
}


class Solution_31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}



