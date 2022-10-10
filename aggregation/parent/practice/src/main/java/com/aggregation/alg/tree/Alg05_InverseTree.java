package com.aggregation.alg.tree;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午8:47
 */
public class Alg05_InverseTree {


    /**
     * @Desc 翻转tree
     * @Date 2022/3/20 下午8:48
     **/
    public void inverseTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inverseTree(treeNode.left);
        inverseTree(treeNode.right);
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
    }

}
