package codetop;

public class t104 {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int left = 0 , right = 0;
        left = maxDepth(root.left)+1;
        right = maxDepth(root.right)+1;
        return Math.max(left,right);
    }
}
