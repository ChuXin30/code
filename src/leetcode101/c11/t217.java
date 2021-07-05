package leetcode101.c11;
//217. 存在重复元素
//        给定一个整数数组，判断是否存在重复元素。
//
//        如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。


/*
明显使用hashset
 */

import java.util.HashSet;

public class t217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0 ; i < nums.length ; i++ ){
            if( hashSet.contains(nums[i]) )return true;
            else hashSet.add(nums[i]);
        }
        return false;
    }
}
