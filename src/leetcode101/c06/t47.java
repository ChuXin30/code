package leetcode101.c06;

//47. 全排列 II
//        给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
//        示例 1：
//
//        输入：nums = [1,1,2]
//        输出：
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        示例 2：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//47. 全排列 II
//        给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
//        示例 1：
//
//        输入：nums = [1,1,2]
//        输出：
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        示例 2：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//，保证相同的数字都相邻

public class t47 {

    void dfs(List<List<Integer>> ret ,  int pos , int[] nums , List<Integer> ans ,   boolean[] visited ){
        if(pos == nums.length){
            ret.add( new ArrayList<Integer>(ans) );
        }else {
            for(int i = 0 ;  i < nums.length ; i++ ){
                if( visited[i] ||   (i >0 && !visited[i-1] && nums[i-1] == nums[i]) )continue;
                visited[i] = true;
                ans.add(nums[i]);
                dfs( ret  , pos + 1 , nums , ans , visited );
                ans.remove(ans.size()-1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> ans = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);

        dfs(ret , 0 , nums ,  ans , visited);
        return  ret;
    }
}
