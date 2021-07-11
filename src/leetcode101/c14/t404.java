package leetcode101.c14;

//404. 左叶子之和
//        计算给定二叉树的所有左叶子之和。

public class t404 {
    int sum;
    void dfs(TreeNode treeNode , boolean flag){
        if(treeNode == null)return ;
        if(flag && treeNode.left == null && treeNode.right == null )sum += treeNode.val;
        dfs(treeNode.left , true);
        dfs(treeNode.right , false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root , false);
        return sum;
    }

    public int sumOfLeftLeaves_1(TreeNode root) {
        if(root==null) return 0;
        return sumOfLeftLeaves_1(root.left)
                + sumOfLeftLeaves_1(root.right)
                + (root.left!=null && root.left.left==null && root.left.right==null ? root.left.val : 0);
    }
}

class Solution_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

