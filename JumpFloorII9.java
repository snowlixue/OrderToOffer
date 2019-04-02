/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级
……它也可以跳上n级。求该青蛙跳上一个n级的
台阶总共有多少种跳法。
 */

public class JumpFloorII9 {
    public static int JumpFloorII(int target) {
        if (target == 1) return target;
        else{
            int k = 1;
            for (int i = 1;i < target;i++)
                k = JumpFloorII(i) + k;
            return k;
        }
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }
}
