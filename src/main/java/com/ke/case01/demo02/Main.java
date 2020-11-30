package com.ke.case01.demo02;

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
     * 实现 ：Pre-order A B D E C F G
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归写法
//        List<Integer> result = new ArrayList<Integer>();
//        if (root  == null){
//            return result;
//        }
//        List<Integer> left = preorderTraversal(root.left);
//        List<Integer> right = preorderTraversal(root.right);
//        result.add(root.val);
//        result.addAll(left);
//        result.addAll(right);
//        return result;
        // 非递归写法
        List<Integer> result = new ArrayList<Integer>();
        if (root  == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
