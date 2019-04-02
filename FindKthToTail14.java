/*
输入一个链表，输出该链表中倒数第k个结点。
 */

public class FindKthToTail14 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        int count=0;
        ListNode p = head;
        while (p != null){ count++; p=p.next;}
        if (count < k || head == null) return null;
        else if (count == k) return head;
        else if (k == 0) return null;
        else {
            ListNode slow = head, fast = head;
            for (int i = 0; i < k - 1; i++) fast = fast.next;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
