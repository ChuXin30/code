package leetcode;

import java.util.LinkedList;

class c241_1 {
    int n;
    int ret;

    public void  dfs( int[] nums , boolean[] visited , LinkedList<Integer> ll , int l  ){
        if(l == n){
            int t = 0;
            for (int i = 0 ; i < ll.size() ; i++){
                t = t^ll.get(i);
            }
            ret += t;
        }

        for(int i = 0 ; i < n ; i++){
            if( !visited[i]  ){
                visited[i] = true;
                dfs( nums , visited , ll , l+1 );
                ll.add(nums[i]);
                dfs( nums , visited , ll , l+1 );
                ll.remove(ll.size()-1);
                visited[i]=false;
            }
        }

    }


     static int subsetXORSum(int[] nums) {
        n = nums.length;
        ret = 0;
        boolean[] visited = new boolean[n];
        LinkedList<Integer> ll = new LinkedList<Integer>();
        dfs(nums , visited , ll , 0);
        return  ret;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsetXORSum( nums));

    }
}
