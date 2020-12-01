package com.ke.case01.demo02;

/**
 * Description:
 * User: zxg QAQ
 * Date: 2020-12-01
 * Time: 0:02
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(){}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
