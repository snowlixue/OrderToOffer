/*
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Stack;
public class MinStack20 {

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    public void push(int node) {
        if (s1.empty()) s2.push(node);
        else s2.push(Math.min(node,s1.peek()));
        s1.push(node);
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }

    public static void main(String[] args) {
        MinStack20 mins = new MinStack20();
        mins.push(3);
        System.out.println(mins.min());
        mins.push(4);
        System.out.println(mins.min());
    }
}
