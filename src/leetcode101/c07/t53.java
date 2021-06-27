package leetcode101.c07;

//53. 最大子序和
//        给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
//        示例 1：
//
//        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//        输出：6
//        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

public class t53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int max = -Integer.MIN_VALUE;

        for(int i = 1 ; i <= nums.length ; i++ ){
            dp[i] = Math.max(dp[i-1]+nums[i-1] , nums[i-1]);
            max = Math.max(max , dp[i]);
        }
        return max;
    }
}
