/*
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount66 {
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) return 0;
        //标志位，初始化为false
        boolean[][] flag = new boolean[rows][cols];
        int count = judge(0,0,rows, cols, flag, threshold);
        return count;
    }
    private static int judge(int i,int j,int rows,int cols,boolean[][] flag,int threshold){
        //递归条件
        int count = 0;
        if(i>=0 && j>=0 && i<rows && j<cols && checkSum(threshold,i,j) && !flag[i][j]) {
            //要走的第一个位置置为true，表示已经走过了
            flag[i][j] = true;

            //回溯，递归寻找，每次找到了就给k加一，找不到，还原
            count = 1 + judge(i - 1, j, rows, cols, flag, threshold) +
                    judge(i + 1, j, rows, cols, flag, threshold) +
                    judge(i, j - 1, rows, cols, flag, threshold) +
                    judge(i, j + 1, rows, cols, flag, threshold);
        }
        return count;
    }

    private static boolean checkSum(int threshold, int row, int col) {
        int sum=0;
        while(row!=0){
            sum+=row%10;
            row=row/10;
        }
        while(col!=0){
            sum+=col%10;
            col=col/10;
        }
        if(sum>threshold) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(5,10,10));
    }
}
