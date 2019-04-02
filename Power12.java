/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */

public class Power12 {
    public static double Power(double base, int exponent) {
        double tmp = base;
        if (exponent > 0)
        for(int i = 1;i<exponent;i++)
            tmp = tmp * base;
        else if (exponent == 0)
            tmp = 1;
        else {
            for(int i = 1;i<Math.abs(exponent);i++)
                tmp = tmp * base;
            tmp = 1/tmp;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(Power(2,-3));
    }
}
