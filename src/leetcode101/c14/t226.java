package leetcode101.c14;

//226. 翻转二叉树
//        翻转一棵二叉树。

/*
递归，每到达一个节点
交互左右两个节点

 显然，我们从根节点开始，递归地对树进行遍历，并从叶子节点先开始翻转。
 如果当前遍历到的节点 \textit{root}root 的左右两棵子树都已经翻转，
 那么我们只需要交换两棵子树的位置，即可完成以 \textit{root}root
 为根节点的整棵子树的翻转。

 */

public class t226 {
    void dfs(TreeNode root){
        if(root == null )return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        dfs(root.right);
        dfs(root.left);

        return;
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
}

class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
