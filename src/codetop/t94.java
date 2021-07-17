package codetop;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//中序遍历
public class t94 {
    //1.使用递归的方法
    ArrayList<Integer> ret;

    public void dfs(TreeNode root){
        if(root == null)return;
        dfs(root.left);
        ret.add(root.val);
        dfs(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ret = new ArrayList<>();
        dfs(root);
        return ret;
    }

    //2.使用栈的方法
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> ret2 = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() && root != null ){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ret2.add(root.val);
            root = root.right;
        }

        return ret2;
    }
}

//前序遍历
class Solution_2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}

//后续遍历递归 不太会
class Solution_3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}

