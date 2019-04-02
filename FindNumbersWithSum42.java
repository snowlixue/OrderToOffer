/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述：对应每个测试案例，输出两个数，小的先输出。
 */
import java.util.ArrayList;
public class FindNumbersWithSum42 {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (array.length == 0) return arrayList;
        int low = 0,high = array.length-1;
        while (low < high){
            if (array[low]+array[high] > sum) high--;
            if (array[low]+array[high] < sum) low++;
            if (array[low]+array[high] == sum) break;
        }
        if (low >= high) return arrayList;
        arrayList.add(array[low]);arrayList.add(array[high]);
        return arrayList;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,16};
        ArrayList<Integer> arrayList = FindNumbersWithSum(array,10);
        for (Integer i:arrayList) System.out.println(i);
    }

}
