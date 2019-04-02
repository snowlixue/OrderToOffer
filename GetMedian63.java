/*
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetMedian63 {

    public static List<Double> list = new ArrayList<>();
    public static void Insert(Integer num) {
        list.add((double)num);
    }

    public static Double GetMedian() {
        Collections.sort(list);
        double mid = 0.00;
        int len = list.size();
        if(len % 2==0) mid = (list.get(len/2-1)+list.get(len/2))/2;
        else mid = list.get(len/2);
        return mid;
    }

    public static void main(String[] args) {
        Insert(2);
        System.out.println(GetMedian());
    }
}
