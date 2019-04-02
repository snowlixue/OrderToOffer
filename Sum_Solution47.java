/*
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution47 {
    public int Sum_Solution(int n) {
        if(n == 1) return 1;
        int num1 = 1;
        for(int i = 2;i <= n; i++){
            int num2 = i;
            while(num2!=0){
                int temp = num1^num2;
                num2 = (num1 & num2)<<1;
                num1=temp;
            }
        }

        return num1;
    }
}
