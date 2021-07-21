package codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//199. 二叉树的右视图
//        给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

public class t199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0 ; i < size ; i++ ){
                TreeNode temp = queue.poll();
                if(temp == null)continue;
                if(temp.left != null)queue.offer(temp.left);
                if(temp.right != null)queue.offer(temp.right);
                if(i == size-1)ret.add(temp.val);
            }
        }
        return  ret;
    }
}

//2 dfs 每层访问的第一元素就是 右视图
class dfs{
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs_f(root , 0);
        return res;
    }

    private void dfs_f(TreeNode root , int deepth){
        if(root == null)return;
        if(deepth == res.size()){
            res.add(root.val);
        }
        dfs_f(root.right , deepth+1);
        dfs_f(root.left , deepth+1);
    }

}