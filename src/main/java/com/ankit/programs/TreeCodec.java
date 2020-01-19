package com.ankit.programs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeCodec
{
    public static void main(String[] args)
    {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = new TreeNode(4);
        right.left = new TreeNode(5);
        System.out.println(codec.serialize(root));
        TreeNode out = codec.deserialize(codec.serialize(root));
        System.out.println(out);
    }
}

class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                builder.append("#,");
            }
            else {
                builder.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        String s = builder.toString();
        System.out.println(s.substring(0, s.length() -1));
        return s.substring(0, s.length() -1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;
        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        int index = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (values[index].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[index]));
                node.left = left;
                queue.add(left);
            }
            index++;
            if (values[index].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[index]));
                node.right = right;
                queue.add(right);
            }
            index++;
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
