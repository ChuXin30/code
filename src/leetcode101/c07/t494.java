package leetcode101.c07;

//494. 目标和
//        给你一个整数数组 nums 和一个整数 target 。
//
//        向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//        例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//        返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//
//
//        示例 1：
//
//        输入：nums = [1,1,1,1,1], target = 3
//        输出：5
//        解释：一共有 5 种方法让最终目标和为 3 。
//        -1 + 1 + 1 + 1 + 1 = 3
//        +1 - 1 + 1 + 1 + 1 = 3
//        +1 + 1 - 1 + 1 + 1 = 3
//        +1 + 1 + 1 - 1 + 1 = 3
//        +1 + 1 + 1 + 1 - 1 = 3
//        示例 2：
//
//        输入：nums = [1], target = 1
//        输出：1

/*
0-1背包问题
搞清楚状态以后，我们就可以根据状态去考虑如何根据子问题的转移从而得到整体的解。这道题的关键不是nums[i]的选与不选，而是nums[i]是加还是减，那么我们就可以将方程定义为：

dp[ i ][ j ] = dp[ i - 1 ][ j - nums[ i ] ] + dp[ i - 1 ][ j + nums[ i ] ]
可以理解为nums[i]这个元素我可以执行加，还可以执行减，那么我dp[i][j]的结果值就是加/减之后对应位置的和。


 */

public class t494 {
    public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(s) > Math.abs(sum)) return 0;

        int len = nums.length;
        // - 0 +
        int t = sum * 2 + 1;
        int[][] dp = new int[len][t];
        // 初始化
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < t; j++) {
                // 边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[len - 1][sum + s];
    }
}


