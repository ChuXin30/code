package leetcode101.c06;
//40. 组合总和 II
//        给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的每个数字在每个组合中只能使用一次。
//
//        说明：
//
//        所有数字（包括目标数）都是正整数。
//        解集不能包含重复的组合。
//        示例 1:
//
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        所求解集为:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]
//        示例 2:
//
//        输入: candidates = [2,5,2,1,2], target = 5,
//        所求解集为:
//        [
//        [1,2,2],
//        [5]
//        ]

import java.util.*;

public class t40 {
    void dfs(List<List<Integer>> ret , int begin ,  int sum , int[] nums , List<Integer> ans , int target){
        if(sum == target){
            ret.add( new ArrayList<Integer>(ans) );
        }else {
            for(int i = begin ;  i < nums.length ; i++ ){
                if(  i > begin && nums[i-1] == nums[i] )continue;
                if((sum + nums[i]) <= target){
                    ans.add(nums[i]);
                    dfs( ret  , i+1 ,  sum + nums[i] , nums , ans   ,target);
                    ans.remove(ans.size()-1);
                }else{
                    break;
                }
            }
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(ret ,  0 , 0 , candidates ,  ans  , target);
        return  ret;
    }

}
