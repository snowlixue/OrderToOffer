/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，
一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请
不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone25 {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) return null;
        RandomListNode newlist1 = pHead;
        RandomListNode newlist4 = pHead;
        //1.链接next至原链表后
        while (newlist4 != null){
            RandomListNode clonelist = new RandomListNode(newlist4.label) ;
            clonelist.next = newlist4.next;
            newlist4.next = clonelist;
            newlist4 = clonelist.next;
        }

        //2.链接random指针
        RandomListNode newlist2 = newlist1;
        while (newlist2.next.next != null){
            if (newlist2.random != null)
                newlist2.next.random = newlist2.random.next;
            else newlist2.next.random = null;
            newlist2 = newlist2.next.next;
        }
        if (newlist2.random != null)
            newlist2.next.random = newlist2.random.next;
        else newlist2.next.random = null;

        //3.删除奇数节点
        RandomListNode lastlist = newlist1.next;
        RandomListNode newlist3 = newlist1;
        RandomListNode newlist5 = newlist1.next;
        while (newlist3 != null && newlist5.next != null){
            newlist3.next = newlist5.next;
            newlist3 = newlist3.next;
            newlist5.next = newlist3.next;
            newlist5 = newlist5.next;
        }
        newlist3.next = null;
        newlist5.next = null;

        return lastlist;
    }
}
