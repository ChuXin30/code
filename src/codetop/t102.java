package codetop;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//102. 二叉树的层序遍历
//        给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

public class t102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<List<Integer>> ret = new ArrayList<>();

        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> path = new ArrayList<>();

            for (int i = 0 ; i < size ; i++ ){
                TreeNode temp = queue.poll();
                if(temp == null) continue;
                path.add(temp.val);
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
            ret.add(path);
        }
        return ret;
    }
}
