/*
统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK37 {
    public static int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) return 0;
        int low = 0,high = array.length-1,mid = (low+high)/2;
        while (low < high){
            if (array[mid] > k) high = mid - 1;
            if (array[mid] < k) low = mid + 1;
            if (array[mid] == k) break;
            mid = (low+high)/2;
        }
        if (array[mid] != k) return 0;
        int count = 1;
        for (int i = mid-1; i >= 0 ; i--)
            if (array[i] == k) count++;
            else break;
        for (int j = mid+1; j < array.length ; j++)
            if (array[j] == k) count++;
            else break;
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1,2,2,2,3,3};
        System.out.println(GetNumberOfK(array,2));
    }
}
