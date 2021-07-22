package codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class t236 {
//    List<ArrayList<TreeNode>> ret = new LinkedList<ArrayList<TreeNode>>();
//
//    void dfs( TreeNode root , TreeNode target ,  ArrayList<TreeNode> path ){
//        if(root == null) return;
//        if(root == target){
//            path.add(target);
//            ret.add(path);
//            return;
//        }
//        path.add(root);
//        dfs(root.left , target ,  path);
//        dfs(root.right , target ,  path);
//        path.remove(path.size()-1);
//        return;
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        ArrayList<TreeNode> path1 = new ArrayList<>();
//        dfs(root , p ,  path1);
//        ArrayList<TreeNode> path2 = new ArrayList<>();
//        dfs(root , p , path2);
//
//        for (int i  = 0 ; i < ret.get(0).size() ; i++ ){
//            System.out.println(ret.get(0).get(i).val);
//        }
//
//        int i = 0 ;
//        while (ret.get(0).get(i)==  ret.get(0).get(i) ){
//            i++;
//        }
//        return ret.get(0).get(i-1);
//    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }



}


//class Solution {
//    List<List<Integer>> ret = new LinkedList<List<Integer>>();
//    Deque<Integer> path = new LinkedList<Integer>();
//
//    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        dfs(root, target);
//        return ret;
//    }
//
//    public void dfs(TreeNode root, int target) {
//        if (root == null) {
//            return;
//        }
//        path.offerLast(root.val);
//        target -= root.val;
//        if (root.left == null && root.right == null && target == 0) {
//            ret.add(new LinkedList<Integer>(path));
//        }
//        dfs(root.left, target);
//        dfs(root.right, target);
//        path.pollLast();
//    }
//}

