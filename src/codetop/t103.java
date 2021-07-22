package codetop;

import java.util.*;

public class t103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            ArrayList<List<Integer>> ret = new ArrayList<>();
            boolean flag = false;
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
                if (flag) flag = false;
                else flag =true;

                if(!flag)Collections.reverse(path);

                if(path.size() != 0)ret.add(path);

            }
            return ret;
    }
}
