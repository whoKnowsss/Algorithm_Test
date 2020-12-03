package algorithm4.chapter1;

import java.util.Arrays;

public class Gcd {
    //欧几里得算法
    //计算两个非负整数p和q的最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) return a; //如果b是0，则返回a
        return gcd(b, a % b);
    }

    public int[] sortedSquares(int[] A) {
        int i, j, k;
        int[] b = new int[A.length];
        int index = 0;
        for (i = 0; i < A.length && A[i] < 0; i++) ;
        for (k = 0, j = i; k < i && j < A.length; ) {
            if (A[k] * A[k] < A[j] * A[j]) {
                b[index++] = A[k] * A[k];
                k++;
            } else {
                b[index++] = A[j] * A[j];
                j++;
            }
        }
        for (; k < i; k++) {
            b[index++] = A[k] * A[k];
        }
        for (; j < A.length; j++) {
            b[index++] = A[j] * A[j];
        }
        return b;
    }
    public int[] sortedSquares(int[] A) {
        // int i,j,temp;
        // for(i=0;i<A.length;i++){
        //     for(j=i+1;j<A.length;j++){
        //         if(A[i]*A[i]>A[j]*A[j]){
        //             temp=A[j];
        //             A[j]=A[i];
        //             A[i]=temp;
        //         }
        //     }
        // }
        for(int i=0;i<A.length;i++){
            A[i]=A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }
    public static void main(String[] args) {
        System.out.println(gcd(1, 2));
    }
}
