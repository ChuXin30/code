package leetcode101.c09;

//462. 最少移动次数使数组元素相等 II
//        给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
//
//        例如:
//
//        输入:
//        [1,2,3]
//
//        输出:
//        2

/*
1.先找到规律。发现在两个元素中间的数，一定是中间那个作为到达的点。
所以就是找到中位数，然后计算其他元素与中位数的差的和。
 */

import java.util.Arrays;

public class t462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int midNum = nums[(nums.length)/2];
        int ret = 0;
        for (int i = 0 ; i < nums.length ; i++ ){
            ret += Math.abs( nums[i] - midNum );
        }
        return ret;
    }
}
//方法二：使用快速选择寻找中位数
class Solution_462 {
    public void swap(int[] list, int i, int pivot_index) {
        int temp = list[i];
        list[i] = list[pivot_index];
        list[pivot_index] = temp;
    }
    public int partition(int[] list, int left, int right) {
        int pivotValue = list[right];
        int i = left;
        for (int j = left; j <= right; j++) {
            if (list[j] < pivotValue) {
                swap(list, i, j);
                i++;
            }
        }
        swap(list, right, i);
        return i;
    }
    int select(int[] list, int left, int right, int k) {
        if (left == right) {
            return list[left];
        }
        int pivotIndex = partition(list, left, right);
        if (k == pivotIndex) {
            return list[k];
        } else if (k < pivotIndex) {
            return select(list, left, pivotIndex - 1, k);
        } else {
            return select(list, pivotIndex + 1, right, k);
        }
    }
    public int minMoves2(int[] nums) {
        int sum = 0;
        int median = select(nums, 0, nums.length - 1, nums.length / 2);

        for (int num : nums) {
            sum += Math.abs(median - num);
        }
        return sum;
    }
}
