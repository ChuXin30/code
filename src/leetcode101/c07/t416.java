package leetcode101.c07;

//416. 分割等和子集
//        给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
//        示例 1：
//
//        输入：nums = [1,5,11,5]
//        输出：true
//        解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//        示例 2：
//
//        输入：nums = [1,2,3,5]
//        输出：false
//        解释：数组不能分割成两个元素和相等的子集。

/*
相当于是0-1背包问题
遇到一个元素判断，是否取这个元素，
直到最后背包内的最大值为sum/2
 */

//有问题
public class t416 {
    public boolean canPartition(int[] nums) {
        int sum  = 0;
        for(int i: nums) sum += i;
        if(sum%2 == 1)return false;
        int n = nums.length;
        boolean[][] dp = new boolean[nums.length+1][sum/2+1];

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for(int i = 1 ; i <= nums.length ; i++ ){
            int w = nums[i-1];
            for(int j = 1 ; j <= sum/2 ; j++ ){
                if( j > w) dp[i][j] =dp[i-1][j]| dp[i-1][j-w] ;
                else dp[i][j] = dp[i-1][j];
            }
        }

        for (int i = 0 ; i <= n ; i++ ){
            for(int j = 1 ; j <= sum/2 ; j++ ){
                System.out.println(dp[i][j] +" ");
            }
            System.out.println();
        }

        return dp[n][sum/2];
    }
}
//正确解答
class Solution_2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
