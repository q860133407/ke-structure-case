package com.ke.case01.demo06;

import com.ke.case01.demo02.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zxg QAQ
 * Date: 2020-12-06
 * Time: 22:45
 */
public class Main {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        for (int i = 0;i<list.size();i++) {
            TreeNode node = list.get(i);
            if (node == null) {
                continue;
            }
            list.add(node.left);
            list.add(node.right);
        }
        while (list.get(list.size()-1) == null) {
            list.remove(list.size() -1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0).val);
        for (int i = 0; i < list.size();i++) {
            if (list.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(","+list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.equals("{}")) {
            return null;
        }
        String [] datas = data.substring(1,data.length()-1).split(",");
        boolean isLeft = true;
        List<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode node = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(node);
        int index = 0;
        for (int i = 1;i<datas.length;i++) {
            if (!datas[i].equals("#")) {
                TreeNode node1 = new TreeNode(Integer.parseInt(datas[i]));
                if (isLeft) {
                    queue.get(index).left = node1;
                } else {
                    queue.get(index).right = node1;
                }
                queue.add(node1);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return queue.get(0);
    }
}
