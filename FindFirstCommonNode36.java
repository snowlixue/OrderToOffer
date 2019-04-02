/*
输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode36 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int m = 0, n = 0;
        ListNode p1 =pHead1;
        ListNode p2 =pHead2;
        while (p1 != null){
            p1 = p1.next;m++;
        }
        while (p2 != null){
            p2 = p2.next;n++;
        }
        if (m>n)
            for (;m > n;m--) pHead1=pHead1.next;
        if (m<n)
            for (;n > m;n--) pHead2=pHead2.next;
        while (pHead1!=null&&pHead2!=null){
            if (pHead1 == pHead2) return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
