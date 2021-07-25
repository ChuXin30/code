package mianshi.rizhiyi;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class t {
//    void dfsMin(TreeNode root ){
//        if(root == null)return;
//
//        dfsMin(root.left );
//
//        path.add(root);
//
//        dfsMin(root.right );
//    }
//
//    TreeNode f(TreeNode root ){
//        path = new ArrayList<TreeNode>();
//        dfsMin(root );
//        return path.get(1);
//    }

    static TreeNode f1(TreeNode root ){
        ArrayList<TreeNode> path =  new ArrayList<TreeNode>();
        if(root == null)return null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null){
            while (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.println(temp.val);
            path.add(temp);
            temp = temp.right;
//            stack.pop();
//            if(temp.right != null)stack.push(temp.right);
        }
        return path.get(1);
    }


    static TreeNode f2(TreeNode root ){
//        ArrayList<TreeNode> path =  new ArrayList<TreeNode>();
        if(root == null)return null;
        TreeNode pre = null;
        TreeNode curr = root;

        while (curr.left != null){
            pre = curr;
            curr = curr.left;
        }
        //当前curr为最小
        if( curr.right == null ){
            return pre;
        }
        else {
            curr = curr.right;
            while (curr.left != null){
                curr = curr.left;
            }
            return curr;
        }
//        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode head = root;

        root.left = new TreeNode(1);
        root = root.left;
        root.right = new TreeNode(2);

        System.out.println(f1(head));

    }

}
