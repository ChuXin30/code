package leetcode101.c11;

import java.util.ArrayList;
import java.util.List;

//448. 找到所有数组中消失的数字
//        给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
//
//
//
//        示例 1：
//
//        输入：nums = [4,3,2,7,8,2,3,1]
//        输出：[5,6]
//        示例 2：
//
//        输入：nums = [1,1]
//        输出：[2]

/*
注意到 \textit{nums}nums 的长度恰好也为 nn，能否让 \textit{nums}nums 充当哈希表呢？

由于 \textit{nums}nums 的数字范围均在 [1,n][1,n] 中，我们可以利用这一范围之外的数字，来表达「是否存在」的含义。

具体来说，遍历 \textit{nums}nums，每遇到一个数 xx，就让 \textit{nums}[x-1]nums[x−1] 增加 nn。由于 \textit{nums}nums 中所有数均在 [1,n][1,n] 中，增加以后，这些数必然大于 nn。最后我们遍历 \textit{nums}nums，若 \textit{nums}[i]nums[i] 未大于 nn，就说明没有遇到过数 i+1i+1。这样我们就找到了缺失的数字。

 */

public class t448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int x : nums){
            int t = (x - 1)%n;
            nums[t] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0 ; i < n ; i++ ){
            if(nums[i] <= n )ret.add(i+1);
        }
        return ret;
    }
}
