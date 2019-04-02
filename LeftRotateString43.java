/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString43 {
    public static String LeftRotateString(String str,int n) {
        if (str.length() == 0) return "";
        Character[] characters = new Character[n];
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i <n ; i++) {
            characters[i] = str.charAt(i);
        }
        for (int i = 0; i <str.length() - n ; i++) {
            stringBuffer.setCharAt(i,stringBuffer.charAt(i+n));
        }
        for (int i = str.length() - n; i <str.length() ; i++) {
            stringBuffer.setCharAt(i,characters[i - str.length() + n]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcdefg",2));
    }
}
