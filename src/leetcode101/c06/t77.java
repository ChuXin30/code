package leetcode101.c06;

import java.util.ArrayList;
import java.util.List;

//77. 组合
//        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//        示例:
//
//        输入: n = 4, k = 2
//        输出:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
public class t77 {
    public void dfs( List<List<Integer>> res , ArrayList<Integer> arrayList , int pos ,  int k , int n){
        if(arrayList.size() == k){
            res.add(new ArrayList<>(arrayList) ); //主要是这里res.add(arrayList ); 如果是原来就不行
            return;
        }
        for(int i = pos+1 ; i <= n ; i++ ){
            arrayList.add(i);
            System.out.println("递归之前 => " + arrayList);

            dfs(res , arrayList , i ,  k , n);
            arrayList.remove(arrayList.size()-1 );
            System.out.println("递归之后 => " + arrayList);

        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        dfs(res , arrayList , 0 , k , n);
        return  res;
    }

}
