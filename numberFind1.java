/*在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，每一列都
按照从上到下递增的顺序排序。请完成一个函数，
输入这样的一个二维数组和一个整数，判断数组中
是否含有该整数。
 */

public class numberFind1 {
    public static boolean Find(int target, int [][] array){

        if(array == null || array.length<1 || array[1].length<1) return false;
        int rows = array.length;
        int cols = array[1].length;
        System.out.println(rows+" "+cols);
        int row = 0,col = cols-1;
        while(row>=0 && row<rows && col>=0 && col<cols){
            if(array[row][col] == target) return true;
            else if(target > array[row][col]) row+=1;
            else if(target < array[row][col]) col-=1;
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]array = {{},{}};
        for(int a[]:array)
            for(int b:a)
            System.out.println(b+" ");
        boolean f = Find(7,array);
        System.out.println(f);
    }
}
