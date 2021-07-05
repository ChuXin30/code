package leetcode101.c11;

//697. 数组的度
//        给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
//
//        你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

/*
先找到最大的度的元素 用一个hashmap。
便利这个hashmap最大值为max的元素加入到数组中
找到元素的开始和结束，相减即为长度

实际上只要一个hashmap就行，key为元素，value为 次数+第一个+第二个
 */

import java.util.HashMap;
import java.util.Map;

public class t697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

}
