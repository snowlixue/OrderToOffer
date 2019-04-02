/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组
中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 1) return array[0];
        if (array.length == 2) return 0;
        int j = 1,tmp = array[0];
        for (int i = 1;i<array.length;i++){
            if (array[i] == tmp) j++;
            if (array[i] != tmp) j--;
            if (j<0) {
                tmp = array[i];
                j = 0;
            }
        }
        if (j > 0) return tmp;
        else return 0;
    }
}
