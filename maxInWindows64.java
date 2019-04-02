import java.util.ArrayList;

/*
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
{2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
import java.util.ArrayDeque;
public class maxInWindows64 {

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(num==null||size<=0)
            return list;
        int i = 0;//i为滑动窗口的开始
        int j = size - 1;//i为滑动窗口的结束
        while(j<=num.length-1){
            list.add(maxValue(num,i,j));//将每个滑动窗口的值加入列表中
            i = i + 1;//向前滑动一位
            j = j + 1;//向前滑动一位
        }
        return list;
    }
    public static int maxValue(int[] a ,int i,int j) {//找出数组从a[i]到a[j]的最大值
        int temp = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            if (temp < a[k])
                temp = a[k];
        }
        return temp;
    }
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        for (Integer i:maxInWindows(num,3)) System.out.println(i);
    }
}
