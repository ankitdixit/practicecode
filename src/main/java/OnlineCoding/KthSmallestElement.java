package OnlineCoding;

import java.util.Stack;

public class KthSmallestElement
{
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args)
            throws Exception
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(Solution.kthSmallest(root, 3));
    }

    static class Result
    {
        Integer result;
    }

    static class Solution
    {

        public static int kthSmallest(TreeNode root, int k)
                throws Exception
        {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            int nodesSeen = 0;
            TreeNode currNode = root;
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (++nodesSeen == k) {
                    return node.val;
                }
                if (node.right != null) {
                    TreeNode rightChild = node.right;
                    while (rightChild != null) {
                        stack.push(rightChild);
                        rightChild = rightChild.left;
                    }
                }
            }
            throw new Exception("Cannot find the kth node");
        }
    }
}
