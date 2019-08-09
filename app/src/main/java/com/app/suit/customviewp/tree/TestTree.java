package com.app.suit.customviewp.tree;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author: 李刘欢
 * @date：2019/7/5 17:54
 * @version:1.0.0
 * @description: TestTree
 */
public class TestTree {

    public void main() {
        reverseBinaryTree(new TreeNode());
        flatten(new TreeNode());
    }

    /**
     * 翻转二叉树
     *
     * @param root
     * @return
     */
    private TreeNode reverseBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode left = reverseBinaryTree(root.left);
            TreeNode right = reverseBinaryTree(root.right);
            root.right = left;
            root.left = right;
            return root;
        }
    }

    /**
     * @param root 把二叉树铺平
     * @return
     */
    private TreeNode flatten(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode left = flatten(root.left);
            TreeNode right = flatten(root.right);
            root.left = null;
            root.right = null;
            if (left == null) {
                root.right = right;
                return root;
            }
            root.right = left;
            TreeNode lastLeft = left;
            while (lastLeft.right != null) {
                lastLeft = lastLeft.right;
            }
            lastLeft.right = right;
            return root;
        }
    }

    /**
     * //返回一个在vg下面的一个View，id为方法的第二个参数
     *
     * @param vg
     * @param id
     * @return
     */
    public static View find(ViewGroup vg, int id) {
        if (vg == null) {
            return null;
        }
        int size = vg.getChildCount();
        //循环遍历所有孩子
        for (int i = 0; i < size; i++) {
            View v = vg.getChildAt(i);
            //如果当前孩子的id相同，那么返回
            if (v.getId() == id) {
                return v;
            }
            //如果当前孩子id不同，但是是一个ViewGroup，那么我们递归往下找
            if (v instanceof ViewGroup) {
                //递归
                View temp = find((ViewGroup) v, id);
                //如果找到了，就返回temp，如果没有找到，继续当前的for循环
                if (temp != null) {
                    return temp;
                }
            }
        }
        //到最后还没用找到，代表该ViewGroup vg 并不包含一个有该id的孩子，返回空
        return null;
    }

}
