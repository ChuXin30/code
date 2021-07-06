package leetcode101.c09;
//
//238. 除自身以外数组的乘积
//        给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
//        其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
//        示例:
//
//        输入: [1,2,3,4]
//        输出: [24,12,8,6]

public class t238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }
}
