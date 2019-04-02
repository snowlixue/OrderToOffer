/*
大家都知道斐波那契数列，
现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */

public class Fibonacci7 {
    public static int Fibonacci(int n) {
        //if (n == 0 || n == 1) return n;
        //else return Fibonacci(n-1)+Fibonacci(n-2);

        if (n == 0 || n ==1) return n;
        else{
            int Fibonacci1 = 0,Fibonacci2 = 1,Fibonacci3 = 0,result = 0;
            for(int i = 2 ;i<=n;i++){
                Fibonacci3 = Fibonacci1 + Fibonacci2;
                Fibonacci1 = Fibonacci2;
                Fibonacci2 = Fibonacci3;
            }
            return Fibonacci3;
        }
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(7));
    }
}
