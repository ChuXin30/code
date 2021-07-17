package codetop;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class t145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while ( root != null || !stack.isEmpty() ){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == pre){
                arrayList.add(root.val);
                pre = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        return arrayList;
    }
}
