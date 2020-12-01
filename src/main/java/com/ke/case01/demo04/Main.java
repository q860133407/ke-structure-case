package com.ke.case01.demo04;

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
     * 实现 ：post-order D E B F C A
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // 递归写法
//        List<Integer> result = new ArrayList<Integer>();
//        if (root == null) {
//            return result;
//        }
//        List<Integer> left = postorderTraversal(root.left);
//        List<Integer> right = postorderTraversal(root.right);
//        result.addAll(left);
//        result.addAll(right);
//        result.add(root.val);
//        return result;
        // 非递归写法 01
//        List<Integer> result = new ArrayList<Integer>();
//        if (root == null) {
//            return result;
//        }
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.peek();
//            if (node.right == null && node.left == null) {
//                result.add(stack.pop().val);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//                node.right = null;
//            }
//            if (node.left != null) {
//                stack.push(node.left);
//                node.left = null;
//            }
//        }
//        return result;
        // 非递归写法 02
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack= new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode curr = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return result;
    }
}
