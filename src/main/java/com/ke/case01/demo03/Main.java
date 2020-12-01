package com.ke.case01.demo03;

import com.ke.case01.demo02.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 * User: zxg QAQ
 * Date: 2020-12-01
 * Time: 0:01
 */
public class Main {

    /**
     * 实现 ：in-order D B E A C F G
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归写法
//        List<Integer> result = new ArrayList<Integer>();
//        if (root == null) {
//            return result;
//        }
//        List<Integer> left = inorderTraversal(root.left);
//        List<Integer> right = inorderTraversal(root.right);
//        result.addAll(left);
//        result.add(root.val);
//        result.addAll(right);
//        return result;
        // 非递归写法
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
