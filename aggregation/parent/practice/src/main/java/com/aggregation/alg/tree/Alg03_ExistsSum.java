package com.aggregation.alg.tree;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午6:58
 */
public class Alg03_ExistsSum {


    public static boolean exists = false;


    /**
     * @Desc 树的路径(终点必须是叶子节点)中 是否有累加和为num的路径
     * @Date 2022/3/20 下午6:58
     **/
    public boolean existsSum(TreeNode treeNode, int sum) {
        existsSum(treeNode, 0, sum);
        return exists;
    }

    public void existsSum(TreeNode treeNode, int preSum, int sum) {
        if (treeNode.left == null && treeNode.right == null) {
            preSum += treeNode.val;
            if (preSum == sum) {
                exists = true;
                return;
            }
        }
        preSum += treeNode.val;
        if (treeNode.left != null) {
            existsSum(treeNode.left, preSum, sum);
        }
        if (treeNode.right != null) {
            existsSum(treeNode.right, preSum, sum);
        }
    }

}
