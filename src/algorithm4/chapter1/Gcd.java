package algorithm4.chapter1;

import java.util.Arrays;

public class Gcd {
    //欧几里得算法
    //计算两个非负整数p和q的最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) return a; //如果b是0，则返回a
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(1, 2));
    }
}
