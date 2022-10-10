package com.aggregation.alg.tree;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午1:42
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }
}
