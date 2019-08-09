package com.app.suit.customviewp.tree;

/**
 * @author: 李刘欢
 * @date：2019/7/5 17:53
 * @version:1.0.0
 * @description: TreeNode
 */
public class TreeNode {
    public TreeNode left,right;
    int value;
    public TreeNode() {
    }
    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
