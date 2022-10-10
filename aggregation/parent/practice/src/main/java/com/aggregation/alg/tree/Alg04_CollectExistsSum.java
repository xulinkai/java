package com.aggregation.alg.tree;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午8:07
 */
public class Alg04_CollectExistsSum {


    /**
     * @Desc 搜集达标的路径和
     * @Date 2022/3/20 下午8:08
     **/
    public List<List<Integer>> collect(TreeNode treeNode, int num) {
        List<List<Integer>> res = new ArrayList<>();
        if (treeNode == null) {
            return res;
        }
        List<Integer> path = Lists.newArrayList();
        collect(treeNode, num, res, path, 0);
        return res;
    }

    public void collect(TreeNode treeNode, int num, List<List<Integer>> res, List<Integer> path, int preNum) {
        if (treeNode.left == null && treeNode.right == null) {
            preNum += treeNode.val;
            if (preNum == num) {
                path.add(treeNode.val);
                res.add(copyList(path));
                //恢复现场
                path.remove(path.size() - 1);
            }
            return;
        }
        preNum += treeNode.val;
        path.add(treeNode.val);
        if (treeNode.left != null) {
            collect(treeNode.left, num, res, path, preNum);
        }
        if (treeNode.right != null) {
            collect(treeNode.right, num, res, path, preNum);
        }
        //当前节点计算完毕之后，把当前节点去掉，回到父节点，走其它路径，恢复现场
        path.remove(path.size() - 1);
    }

    public List<Integer> copyList(List<Integer> list) {
        List<Integer> copyList = new ArrayList<>();
        for (Integer integer : list) {
            copyList.add(integer);
        }
        return copyList;
    }


}
