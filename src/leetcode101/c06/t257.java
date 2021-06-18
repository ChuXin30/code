package leetcode101.c06;

import java.util.ArrayList;
import java.util.List;

//257. 二叉树的所有路径
//        给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//
//        输入:
//
//        1
//        /   \
//        2     3
//        \
//        5
//
//        输出: ["1->2->5", "1->3"]
//
//        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3


//  Definition for a binary tree node.



public class t257 {
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

    public void dfs(TreeNode root , List<Integer> path, List<String> ret ){
        if(root.left == null && root.right == null){
            String s = "";
            for (int i = 0 ; i < path.size() ; i++ ){
                s = path.get(i).toString() + "->";
            }
            ret.add( s + Integer.toString(root.val)  );
        }
        path.add(root.val);
        if(root.left != null) dfs(root.left , path , ret );
        if(root.right != null) dfs(root.right , path , ret);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(root , path , ret );
        return ret;
    }

}
