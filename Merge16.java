/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge16 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
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

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return  list2;
        if (list2 == null) return  list1;
        ListNode newlist = null;
        if (list1.val <= list2.val) {
            newlist = list1;
            list1 = list1.next;
        }
        else {
            newlist = list2;
            list2 = list2.next;
        }
        ListNode resultlist = newlist;
        while (list1 != null && list2 != null){
            newlist.next = (list1.val<=list2.val?list1:list2);
            if (list1.val <= list2.val) list1 = list1.next;
            else if (list2.val < list1.val) list2 = list2.next;
            newlist = newlist.next;
        }

        if (list1 != null) newlist.next = list1;
        if (list2 != null) newlist.next = list2;
        return resultlist;
    }

    public static void main(String[] args) {
        int[] target1 = {1,3,5};
        int[] target2 = {2,4,6};
        disPlay(Merge(createList(3,target1),createList(3,target2)));
    }
}
