package com.aggregation.alg.tree;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午6:33
 */
public class Alg02_IsSearchTree {

    /**
     * @Desc 是否是搜索二叉树：左子树的值均小于根节点的值，右子树的值均大于根节点，左右自述均是搜索二叉树
     * @Date 2022/3/20 下午6:40
     **/
    public boolean isSearchTree(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        return getTreeInfo(treeNode).isSearchTree;
    }

    public TreeInfo getTreeInfo(TreeNode treeNode) {
        if (treeNode == null) {
            return new TreeInfo(true, 0, 0);
        }
        int min = treeNode.val;
        int max = treeNode.val;
        boolean isSearchTree = true;
        if (treeNode.left != null) {
            TreeInfo leftTreeInfo = getTreeInfo(treeNode.left);
            min = Math.min(min, leftTreeInfo.min);
            max = Math.max(max, leftTreeInfo.max);
            if (leftTreeInfo.max > treeNode.val || !leftTreeInfo.isSearchTree) {
                isSearchTree = false;
            }
        }

        if (treeNode.right != null) {
            TreeInfo rightTreeInfo = getTreeInfo(treeNode.right);
            min = Math.min(min, rightTreeInfo.min);
            max = Math.max(max, rightTreeInfo.max);
            if (rightTreeInfo.min < treeNode.val || !rightTreeInfo.isSearchTree) {
                isSearchTree = false;
            }
        }

        return new TreeInfo(isSearchTree, max, min);
    }


    private class TreeInfo {
        public boolean isSearchTree;
        public int max;
        public int min;

        public TreeInfo(boolean isSearchTree, int max, int min) {
            this.isSearchTree = isSearchTree;
            this.max = max;
            this.min = min;
        }
    }


}
