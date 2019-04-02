/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的
后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class ReOrderArray13 {
    public static void reOrderArray(int [] array) {
        for (int i = array.length; i > 0; i--){
            int flag = 0;
            int p1 = 0,p2 = 1,tmp = 0;
            while (p1 < i && p2 < i){
                flag = 0;
                System.out.println("no");
                if (array[p1] % 2 == 0 && array[p2] % 2 == 1){
                    tmp = array[p1];
                    array[p1] = array[p2];
                    array[p2] = tmp;
                    flag = 1;
                    System.out.println("yes");
                }
                p1++;p2++;
            }
            if (flag == 0) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        reOrderArray(array);
        for (int a:array)
        System.out.println(a);
    }
}
