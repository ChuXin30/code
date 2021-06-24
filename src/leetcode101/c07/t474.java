package leetcode101.c07;

//474. 一和零
//        给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//        请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
//
//        如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
//
//
//
//        示例 1：
//
//        输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//        输出：4
//        解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//        其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
//        示例 2：
//
//        输入：strs = ["10", "0", "1"], m = 1, n = 1
//        输出：2
//        解释：最大的子集是 {"0", "1"} ，所以答案是 2 。

/*
感觉还是0-1背包问题，
dp[k][i][j] 代表的 有i个0 和 j个1 时候 的最大值
动态规划的思路是：物品一个一个尝试，容量一点一点尝试，每个物品分类讨论的标准是：选与不选。
 */

public class t474 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int length = strs.length;
            int[][][] dp = new int[length + 1][m + 1][n + 1];
            for (int i = 1; i <= length; i++) {
                int[] zerosOnes = getZerosOnes(strs[i - 1]);
                int zeros = zerosOnes[0], ones = zerosOnes[1];
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (j >= zeros && k >= ones) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                        }
                    }
                }
            }
            return dp[length][m][n];
        }

        public int[] getZerosOnes(String str) {
            int[] zerosOnes = new int[2];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                zerosOnes[str.charAt(i) - '0']++;
            }
            return zerosOnes;
        }
    }

}
