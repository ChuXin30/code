package mianshi.huawei;


import java.util.ArrayList;

public class t1 {
    class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
    }

    int ret;

    void dfs(TreeNode root , TreeNode target , ArrayList<TreeNode> path){
        if(root == null)return ;
        if(root == target){
            path.add(target);
            return ;
        }else {
            path.add(root);
            dfs(root.left , target , path);
            dfs(root.right , target , path);
//            path.remove(path.size()-1);
        }
    }


    int findMinPath(TreeNode root , TreeNode node1 , TreeNode node2){
        ret = 0;
        ArrayList<TreeNode> arrayList1 = new ArrayList<>();
        ArrayList<TreeNode> arrayList2 = new ArrayList<>();
        dfs(root , node1 , arrayList1);
        dfs(root , node2 , arrayList2);

        int n = Math.min(arrayList1.size() , arrayList2.size());
        int com = 0;
        for (int i = 0 ; i < n ; i++ ){
            if(   arrayList1.get(i) == arrayList2.get(i) ){
                com ++;
            }
        }

        return (arrayList1.size() + arrayList2.size() - (com-1)*2 );
    }



    public static void main(String[] args) {

    }
}
