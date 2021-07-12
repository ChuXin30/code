package leetcode101.c14;

//105. 从前序与中序遍历序列构造二叉树
//        给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。

import java.util.HashMap;

public class t105 {
    int[] pre;
    int[] in;
    HashMap<Integer , Integer> hashMap = new HashMap<>();



    TreeNode build( int pre_start , int pre_end , int in_start , int in_end  ){
        if(pre_start > pre_end)return null; //注意退出的条件

        TreeNode root = new TreeNode(pre[pre_start]);
        int index = hashMap.get(pre[pre_start]);
        int left_size = index - in_start;

        root.left = build( pre_start+1 , pre_start+left_size, in_start , in_start+left_size     );
        root.right = build(  pre_start+left_size+1 , pre_end ,   in_start+left_size+1 , in_end  );
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        for(int i = 0 ; i < inorder.length ; i++ ){
            hashMap.put(inorder[i] , i);
        }

        return build( 0 , inorder.length-1 , 0 , inorder.length-1 );
    }
}
