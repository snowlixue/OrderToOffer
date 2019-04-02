/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

public class NumberOf1_11 {
/*
* 负数的反码是将其原码除符号位之外的各位求反
[-3]反=[10000011]反=11111100
负数的补码是将其原码除符号位之外的各位求反之后在末位再加1。
[-3]补=[10000011]补=11111101
一个数和它的补码是可逆的。

为什么要设立补码呢？

第一是为了能让计算机执行减法：
[a-b]补=a补+（-b）补

第二个原因是为了统一正0和负0
正零：00000000
负零：10000000
这两个数其实都是0，但他们的原码却有不同的表示。
但是他们的补码是一样的，都是00000000
特别注意，如果+1之后有进位的，要一直往前进位，包括符号位！（这和反码是不同的！）
[10000000]补
=[10000000]反+1
=11111111+1
=(1)00000000
=00000000(最高位溢出了，符号位变成了0）
*
*
*如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，
* 那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1
* (如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。
减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.
我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
这个时候如果我们再把原来的整数和减去1之后的结果做与运算，
从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.
也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
*
*/
    public int NumberOf1(int n) {
//        int count = 0;
//        while(n!= 0){
//            count++;
//            n = n & (n - 1);
//        }
//        return count;
        int t=0;
        char[]ch=Integer.toBinaryString(n).toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1'){
                t++;
            }
        }
        return t;

    }
}
