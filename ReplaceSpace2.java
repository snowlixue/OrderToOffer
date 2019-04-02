/*
请实现一个函数，将一个字符串中的
每个空格替换成“%20”。例如，当字符
串为We Are Happy.则经过替换之后的字符
串为We%20Are%20Happy。
 */


public class ReplaceSpace2 {
    public static String replaceSpace(StringBuffer str){
        int count = 0;
        for(int i =0;i<str.length();i++)
            if(str.charAt(i)==' ')
                count+=1;
        int p1 = str.length()-1;
        int p2 = str.length() + count * 2;
        str.setLength(p2);
        p2-=1;
        while (p1>=0 && p2>=0){
            if(str.charAt(p1) != ' '){
                str.setCharAt(p2,str.charAt(p1));
                p1-=1;p2-=1;
                System.out.println("if");
            }
            else{
                str.setCharAt(p2,'0'); p2-=1;
                str.setCharAt(p2,'2'); p2-=1;
                str.setCharAt(p2,'%'); p2-=1;p1-=1;
                System.out.println("else");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        String st = replaceSpace(sb);
        System.out.println(st);
    }
}
