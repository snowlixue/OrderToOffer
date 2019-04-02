/*
输入两个整数序列，第一个序列表示栈的压入顺序，
请判断第二个序列是否可能为该栈的弹出顺序。假设
压入栈的所有数字均不相等。例如序列1,2,3,4,5是某
栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一
个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹
出序列。（注意：这两个序列的长度是相等的）
 */

import java.util.Stack;

public class IsPopOrder21 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack<>();
        int i = 0,j = 0;
        s.push(pushA[i++]);
        while (j<popA.length){
            while (popA[j] != s.peek()){
                if (i == pushA.length) return false;
                s.push(pushA[i++]);
            }
            s.pop();
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popB = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushA,popB));
    }
}
