package dp;


import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-11
 * @Description: 斐波那契 0、1、1、2、3、5、8、13、21、34
 * @Version: 1.0
 */
public class Fibonacci {
    private static long[] dp = new long[100];

    static void main() {
        // 默认全是 -1
        Arrays.fill(dp, -1);
        // 第一项是 0，第二项是 1
        dp[0] = 0;
        dp[1] = 1;

        // System.out.println(getFibonacci(10));
        System.out.println(getFibonacci(10));
    }

    /**
     * 获取某一项斐波那契数组的值（自顶向下）
     *
     * @param n 第 n 项
     * @return 第 n 项斐波那契数组的值
     */
    public static long getFibonacci(int n) {
        // 初始数组值都是 -1，若不是 -1，代表已经该项数已经计算并记录在对应数组了
        if (dp[n] != -1) {
            return dp[n];
        }
        // 运行到这里意味着还没用算过第 n 项，开始计算第 n 项
        dp[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return dp[n];
    }

    /**
     * 获取某一项斐波那契数组的值（自底向上）
     *
     * @param n 第 n 项
     * @return 第 n 项斐波那契数组的值
     */
    public static long getFibonacci2(int n) {
        // 初始数组值都是 -1，若不是 -1，代表已经该项数已经计算并记录在对应数组了
        if (dp[n] != -1) {
            return dp[n];
        }
        // 对第 2 项到第 n 项的值进行计算
        for (int i = 2; i <= n; i++) {
            // 若该值是 -1 ，则代表该值需要计算，反之则不用
            if (dp[i] == -1) {
                // 计算该值
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
