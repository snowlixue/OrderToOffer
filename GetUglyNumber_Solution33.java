/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。 习
惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution33 {
    public static int GetUglyNumber_Solution(int index) {

        if(index<=0)
            return 0;
        int[] result = new int[index];
        int count = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        result[0] = 1;
        int tmp = 0;
        while (count < index-1) {
            tmp = Math.min(result[i2] * 2, Math.min(result[i3] * 3, result[i5] * 5));
            if(tmp==result[i2] * 2) i2++;//三条if防止值是一样的，不要改成else的
            if(tmp==result[i3] * 3) i3++;
            if(tmp==result[i5] * 5) i5++;
            result[++count]=tmp;
        }
        return result[index - 1];
    }

    public static void main(String[] args) {
        System.out.println( GetUglyNumber_Solution(5));
    }
}
