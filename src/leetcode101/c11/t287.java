package leetcode101.c11;

//287. 寻找重复数
//        给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//
//        假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
//
//        你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
//
//
//
//        示例 1：
//
//        输入：nums = [1,3,4,2,2]
//        输出：2

/*
使用了环形链表的思想
即找到环形链表的入口
 */

public class t287 {
    public int findDuplicate(int[] nums) {
        int slow = 0 ;
        int fast = 0 ;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p1 = 0;
        int p2 = slow;
        while ( p1 != p2){
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}
