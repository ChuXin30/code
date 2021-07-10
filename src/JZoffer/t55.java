package JZoffer;

public class t55 {
    int deepth( TreeNode treeNode , int deep){
        deep = deep+1;
        if(treeNode == null) return deep  ;
        int depth1 =  deepth(treeNode.left , deep);
        int depth2 = deepth(treeNode.right , deep);
        return Math.max(depth1 , depth2);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        if( Math.abs( deepth(root.left , 0) - deepth(root.right , 0) ) <= 1 ){
            return isBalanced(root.left) && isBalanced(root.right);
        }else {
            return  false;
        }
    }
}

class Solution_1 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}


class Solution_2 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
