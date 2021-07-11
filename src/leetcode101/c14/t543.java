package leetcode101.c14;

//543. 二叉树的直径
//        给定一棵二叉树，你需要计算它的直径长度。
//        一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
//        这条路径可能穿过也可能不穿过根结点。

/*
字节面过的题
当时的想法是用bfs来做的，然后也没有怎么写全，所以直接无了
但是用递归要简单

任意一个结点，都要记录以此结点为根的直径情况：左子树高度+右子树高度

同样的，我们可以利用递归来处理树。解题时要注意，在我们处理某个子树时，我们更新的
最长直径值和递归返回的值是不同的。这是因为待更新的最长直径值是经过该子树根节点的最长
直径（即两侧长度）；而函数返回值是以该子树根节点为端点的最长直径值（即一侧长度），使用
这样的返回值才可以通过递归更新父节点的最长直径值）。

 */

public class t543 {
    int w;
    int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        w = Math.max( left + right , w);
        return Math.max( left , right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        w = 0;
        dfs(root);
        return w;
    }
}
