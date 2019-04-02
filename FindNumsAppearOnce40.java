/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

import java.util.LinkedHashMap;
public class FindNumsAppearOnce40 {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i <array.length ; i++) {
            if (linkedHashMap.containsKey(array[i])) linkedHashMap.put(array[i],linkedHashMap.get(array[i])+1);
            else linkedHashMap.put(array[i],1);
        }
        for (int i = 0; i <array.length ; i++) {
            if (linkedHashMap.get(array[i]) == 1 && num1[0] == 0){
                num1[0] = array[i];
            }
            else if (linkedHashMap.get(array[i]) == 1 && num1[0] != 0){
                num2[0] = array[i];
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] array = {2,4,3,6,3,2,5,5};
        FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }
}
