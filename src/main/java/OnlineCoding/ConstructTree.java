package OnlineCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructTree
{
    private static ThreadLocal<Integer> curr = new ThreadLocal<>();

    public static void main(String[] args)
    {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        /*Solution.buildTree(preorder, inorder);*/

        Solution solution = new Solution();
        Map<Integer, Integer> valueToIndexMap = new HashMap<>(preorder.length);
        for (int i = 0; i < inorder.length; i++) {
            valueToIndexMap.put(inorder[i], i);
        }
        curr.set(0);
        TreeNode a = solution.buildTree(preorder, 0, preorder.length - 1, valueToIndexMap);
        System.out.println("debug ke liye");
    }

    /** Definition for a binary tree node.*/
    public static class TreeNode
    {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) { val = x; }
    }
    static class Solution {
        public static TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> valueToIndexMap = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                valueToIndexMap.put(inorder[i], i);
            }
            TreeNode root = null;
            for(int i = 0; i < preorder.length; i++) {
                TreeNode node = new TreeNode(preorder[i]);
                if (root == null) {
                    root = node;
                    continue;
                }
                TreeNode currNode = root;
                TreeNode lastNode;
                while (true) {
                    lastNode = currNode;
                    if (valueToIndexMap.get(preorder[i]) < valueToIndexMap.get(currNode.val)) {
                        currNode = currNode.left;
                        if (currNode == null) {
                            lastNode.left = node;
                            break;
                        }
                    }
                    else {
                        currNode = currNode.right;
                        if (currNode == null) {
                            lastNode.right = node;
                            break;
                        }
                    }
                }
            }
            return root;
        }

        public TreeNode buildTree(int[] preOrder, int startIn, int endIn, Map<Integer, Integer> valueToIndexMap)
        {
            if (startIn > endIn) return null;
            TreeNode node = new TreeNode(preOrder[curr.get()]);
            if (startIn == endIn) {
                curr.set(curr.get() + 1);
                return node;
            }
            int pos = valueToIndexMap.get(preOrder[curr.get()]);
            curr.set(curr.get() + 1);
            node.left = buildTree(preOrder, startIn, pos -1, valueToIndexMap);
            node.right = buildTree(preOrder, pos+1, endIn, valueToIndexMap);
            return node;
        }
    }
}
