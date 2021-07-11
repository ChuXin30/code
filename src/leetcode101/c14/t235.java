package leetcode101.c14;

//235. 二叉搜索树的最近公共祖先
//        给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//        例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]



public class t235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val , q.val);
        int max= Math.max(p.val , q.val);
        if(root.val <= max && root.val >= min)return root;
        else if(root.val > max) return lowestCommonAncestor(root.left , p ,q);
        else if(root.val < min) return lowestCommonAncestor(root.right , p , q);
        return root;
    }
}

class Solution_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * @Author biggerman
         *      二叉搜索树特性：左子树比根节点小，右子树比根节点大
         *      三种情况
         *          第一种：p，q均在root的右子树
         *          第二种：p，q均在root的左子树
         *          第三种：，最近祖先只能是root
         **/

//        第一种情况，p和q都在右子树，应该把视角放在右边，去右子树找第三种情况
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
//        第二种情况，p和q都在左子树，应该把视角放在左边，去左子树找第三种情况
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
//        第三种情况，p,q不在同一子树，只能是p，q分别在一左一右，或者，p，q其中一个是根节点，都返回root
        return root;
    }
}