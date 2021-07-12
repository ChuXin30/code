package leetcode101.c14;

//236. 二叉树的最近公共祖先
//        给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
//        满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”



public class t2326 {

    //做出来了 但是复杂度太高
    boolean find(TreeNode root , TreeNode p){
        if(root == null)return false;
        if(root == p)return true;
        return find(root.left , p) || find(root.right , p);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( find(root.left , p) && find(root.right ,q) || find(root.left , q) && find(root.right ,p) )return root;
        else if(find(root.right , p) && find(root.right , q)  ){
            return lowestCommonAncestor(root.right,  p,  q);
        }else if(  find(root.left , p) && find(root.left , q) ){
            return lowestCommonAncestor(root.left,  p,  q);
        }
        return root;
    }
}

class Solution_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.

        return root; // 2. if(left != null and right != null)

    }
}

