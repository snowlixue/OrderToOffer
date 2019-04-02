/*
输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList15 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        ListNode p1 = head, p2 = head, p3 = head;
        if (head == null) return null;
        if (head.next == null) return head;
        else if (head.next.next == null) {
            p2 = head.next;
            p2.next = p1;
            p1.next = null;
            return p1;
        }
        else if (head.next.next.next == null){
            p2 = head.next;
            p3 = head.next;
            p3.next = p2;
            p2.next = p1;
            p1.next = null;
            return p3;
        }
        else{
            p2 = p1.next;
            p3 = p2.next;
            p1.next = null;
            while (p3.next != null){
                System.out.println("=======use==========");
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
            }
            p3.next = p2;
            p2.next = p1;
            return p3;
        }
    }

    public static ListNode createList(int n, int[] target){
        ListNode head = new ListNode(target[0]), lnext = head;
        for (int i = 1;i < n;i++){
            ListNode newline = new ListNode(target[i]);
            lnext.next = newline;
            lnext = newline;
        }
        lnext.next = null;
        return head;
    }

    public static void disPlay(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] target = {1,2,3,4,5};
        disPlay(ReverseList(createList(5,target)));
    }
}
