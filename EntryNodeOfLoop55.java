/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop55 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode slow = pHead,fast = pHead;
        boolean flag = false;
        while (fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                flag = true;
                break;
            }
        }

        if (flag == true){
            ListNode enter = pHead;
            while (enter != slow){
                enter = enter.next;
                slow = slow.next;
            }
            return slow;
        }

        return null;
    }
}
