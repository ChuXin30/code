package src.jianzhiOFFER;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenhao
 * @date 2022/11/4 23:56
 */
public class t34 {
    List<List<Integer>> ret ;
    List<Integer> path ;

    void dfs(TreeNode root, int target  ){
        if(root == null){
            return;
        }

        path.add(root.val);

        target = target - root.val;
        if(target == 0 && root.left == null && root.right == null){
            List<Integer> copy = new ArrayList<>(path) ;
            ret.add(copy);
        }

        dfs(root.left , target );
        dfs(root.right , target );


        path.remove(path.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        path = new LinkedList<>();
        ret = new ArrayList<>();
        dfs(root , target );
        return ret;
    }

    public static void main(String[] args) {


        System.out.printf("1");
    }


/**
* Definition for a binary tree node.
*/
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
    }
 }


}
