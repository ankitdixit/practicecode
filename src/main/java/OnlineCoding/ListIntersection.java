package OnlineCoding;

public class ListIntersection
{
    public class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    public class Solution
    {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB)
        {
            ListNode pA = headA;
            ListNode pB = headB;
            if (pA == pB) {
                return pA;
            }
            else {
                pA = pA.next;
                pB = pB.next;
            }
            while (true) {
                if (pA == pB) {
                    return pA;
                }
                else if (pA == headA) {
                    return null;
                }
                else {
                    if (pA.next == null) {
                        pA = headB;
                    }
                    else {
                        pA = pA.next;
                    }
                    if (pB.next == null) {
                        pB = headA;
                    }
                    else {
                        pB = pB.next;
                    }
                }
            }
        }
    }
}
