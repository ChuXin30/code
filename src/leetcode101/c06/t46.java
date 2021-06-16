package leetcode101.c06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//46. 全排列
//        给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
//        示例 1：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//        示例 2：
//
//        输入：nums = [0,1]
//        输出：[[0,1],[1,0]]
//        示例 3：
//
//        输入：nums = [1]
//        输出：[[1]]
public class t46 {
    List<List<Integer>> res;

    public void dfs(int n, List<Integer> output , int first){
        if( first == n){
            res.add(new ArrayList<Integer>(output));
        }

        for(int i = first ; i < n ; i++ ){
            Collections.swap(output , first , i);
            dfs(n , output  , first + 1);
            Collections.swap(output , first , i);
        }


    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for(int num: nums){
            output.add(num);
        }
        int n = nums.length;
        dfs(n , output , 0);
        return res;
    }
}
