/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

import java.util.ArrayList;
public class GetLeastNumbers_Solution29 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        if (k > input.length) return null;
        for (int i = 0;i<k;i++){
            for (int j = 0;j<input.length -1 - i;j++){
                if (input[j]<input[j+1]){
                    int tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }
            al.add(input[input.length-i-1]);
        }
        return al;
    }

    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> al = GetLeastNumbers_Solution(a,4);
        for (int b:al) System.out.println(b);
    }
}
