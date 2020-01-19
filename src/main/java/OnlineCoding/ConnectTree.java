package OnlineCoding;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;

public class ConnectTree
{
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Queue<Node> queue = new ArrayDeque<>();
            int level = 0;
            queue.add(root);
            while(!queue.isEmpty()) {
                Node head = null;
                for (int i = 0; i < Math.pow(2, level); i++) {
                    if(head == null) {
                        head = queue.poll();
                        if (head.left != null) queue.add(head.left);
                        if (head.right != null) queue.add(head.right);
                    }
                    else {
                        Node next = queue.poll();
                        if (next != null) {
                            head.next = next;
                            if (next.left != null) queue.add(next.left);
                            if (next.right != null) queue.add(next.right);
                            head = next;
                        }
                    }
                }
                level++;
            }
            return root;
        }
    }

    public static void main(String[] args)
    {
        Integer i;
        i = 1;
        Solution solution = new Solution();
        Node node4 = new Node(4, null,null, null);
        Node node5 = new Node(5, null,null, null);
        Node node6 = new Node(6, null,null, null);
        Node node7 = new Node(7, null,null, null);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);
        Node node1 = new Node(1, node2, node3, null);

        solution.connect(node1);
    }
}
