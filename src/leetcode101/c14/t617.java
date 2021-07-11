package leetcode101.c14;

//617. 合并二叉树
//        给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
//        你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
//        那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

/*
不太会递归，写的垃圾代码
 */

public class t617 {
//    public void dfs(TreeNode root1, TreeNode root2 , TreeNode pre , Boolean flag) {
//        if(root1 == null && root2 == null)return ;
//        else if(root1 != null && root2 != null){
//            root1.val = root1.val + root2.val;
//            if(flag)pre.left =  new TreeNode(root1.val) ;
//            else pre.right = new TreeNode(root1.val) ;
//        }else if(root1 == null){
//            if(flag)pre.left = new TreeNode(root2.val) ;
//            else pre.right = new TreeNode(root2.val) ;
//        }else {
//            if(flag)pre.left = new TreeNode(root1.val) ;
//            else pre.right = new TreeNode(root1.val) ;
//        }
//        dfs(root1.left , root2.left , pre.left , true);
//        dfs(root1.right , root2.right , pre.right , false);
//    }
//
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        TreeNode pre = new TreeNode();
//
//        dfs(root1 , root2 , pre , true);
//        return pre.left;
//    }
}
class Solution_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}



