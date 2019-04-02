/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。
 */
public class Multiply51 {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        int[] C = new int[length];
        int[] D = new int[length];
        if(A.length == 1 || A.length == 0) return A;
        B[0] = A[0];
        C[0] = A[length-1];
        for(int i = 1;i <length;i++ ) B[i] = B[i-1]*A[i];
        for(int i = 1;i <length;i++ ) C[i] = C[i-1]*A[length-(i+1)];
        D[0] = C[length-2];
        D[length - 1] = B[length - 2 ];
        for(int i = 1;i <length - 1;i++) D[i] = B[i-1]*C[length-(i+2)];
        return D;
    }
}
