package leetcode101.c11;

//594. 最长和谐子序列
//        和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
//
//        现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
//
//        数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。

/*
谐子序列长度，序列只能包含两个元素，
长度等于大小相邻两个元素的个数之和
 */

import java.util.HashMap;

public class t594 {
    public int findLHS(int[] nums) {
        HashMap< Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }
}
