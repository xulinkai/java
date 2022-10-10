package com.aggregation.alg.tree;

/**
 * 是否是平衡二叉树
 */
public class Alg01_IsBSTTree {


    /**
     * @Desc 是否是平衡二叉树
     * @Date 2022/3/20 下午1:43
     **/
    public boolean isBSTTree(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }

        return getTreeInfo(treeNode).isBSTTree;
    }

    public TreeInfo getTreeInfo(TreeNode treeNode) {
        if (treeNode == null) {
            return new TreeInfo(true, 0);
        }
        TreeInfo leftInfo = getTreeInfo(treeNode.left);
        TreeInfo rightInfo = getTreeInfo(treeNode.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBST = leftInfo.isBSTTree && rightInfo.isBSTTree && Math.abs(leftInfo.height - rightInfo.height) < 2;

        return new TreeInfo(isBST, height);
    }


    private class TreeInfo {
        public boolean isBSTTree;
        public int height;

        public TreeInfo(boolean isBSTTree, int height) {
            this.isBSTTree = isBSTTree;
            this.height = height;
        }
    }
}


