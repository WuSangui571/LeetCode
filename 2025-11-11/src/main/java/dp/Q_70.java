package dp;


import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-11
 * @Description: 爬楼梯
 * @Version: 1.0
 */
public class Q_70 {
    // 辅助数组，我自己写的，最高 45 阶台阶
    static int[] arr = new int[46];

    static void main() {
        // 题目：一共有 n 阶台阶，你每次可以爬 1 阶或 2 阶。请问有多少种不同的方式爬到顶？

        // n 是题目输入，代表有 n 阶台阶
        //int n = 5;
        int n = 10;

        // 计算结果
        int res = climbStairs6(n);
        // 输出结果
        System.out.println(res);
    }

    /**
     * 爬楼梯的方法（自顶向下）
     *
     * @param n 代表 n 阶台阶
     * @return 爬 n 阶台阶的有多少种不同的方式
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            // 1 阶台阶有一种走法
            arr[n] = 1;
            return arr[n];
        }
        if (n == 2) {
            // 2 阶台阶有两种走法
            arr[n] = 2;
            return arr[n];
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        // 第 n 阶台阶（n>2）,一定是从 n-1 阶台阶和 n-2 阶台阶走来的
        // 那么走第 n 阶台阶的走法，就是 n-1 阶台阶的走法加上 n-2 阶台阶的走法
        arr[n] = climbStairs(n - 1) + climbStairs(n - 2);

        return arr[n];
    }

    /**
     * 爬楼梯的方法（自底向上）
     *
     * @param n 代表 n 阶台阶
     * @return 爬 n 阶台阶的有多少种不同的方式
     */
    public static int climbStairs2(int n) {
        // 1 阶台阶有一种走法
        arr[1] = 1;

        // 2 阶台阶有两种走法
        arr[2] = 2;

        // 第 n 阶台阶（n>2）,一定是从 n-1 阶台阶和 n-2 阶台阶走来的
        // 那么走第 n 阶台阶的走法，就是 n-1 阶台阶的走法加上 n-2 阶台阶的走法
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    /**
     * 爬楼梯的方法（邪修，无需数组存储）
     *
     * @param n 代表 n 阶台阶
     * @return 爬 n 阶台阶的有多少种不同的方式
     */
    public static int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 每次可以爬 1、2 或 3 阶的爬楼梯的方法（下到上）
     *
     * @param n 代表 n 阶台阶
     * @return 爬 n 阶台阶的有多少种不同的方式
     */
    public static int climbStairs4(int n) {
        // 1 阶台阶有一种走法
        arr[1] = 1;

        // 2 阶台阶有两种走法
        arr[2] = 2;

        // 3 阶台阶有三种走法
        arr[3] = 3;

        // 第 n 阶台阶（n>3）,一定是从 n-1 阶台阶和 n-2 阶台阶和 n-3 阶台阶走来的
        // 那么走第 n 阶台阶的走法，就是 n-1 阶台阶的走法加上 n-2 阶台阶的走法
        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }

    /**
     * 每次可以爬 1、2 或 3 阶的爬楼梯的方法（上到下）
     *
     * @param n 代表 n 阶台阶
     * @return 爬 n 阶台阶的有多少种不同的方式
     */
    public static int climbStairs5(int n) {
        if (n == 1) {
            // 1 阶台阶有一种走法
            arr[n] = 1;
            return arr[n];
        }
        if (n == 2) {
            // 2 阶台阶有两种走法
            arr[n] = 2;
            return arr[n];
        }
        if (n == 3) {
            // 3 阶台阶有三种走法
            arr[n] = 3;
            return arr[n];
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        // 第 n 阶台阶（n>4）,一定是从 n-1 阶台阶和 n-2 阶台阶和 n-3 阶台阶走来的
        // 那么走第 n 阶台阶的走法，就是 n-1 阶台阶的走法加上 n-2 阶台阶，加上 n-3 阶台阶的走法
        arr[n] = climbStairs5(n - 1) + climbStairs5(n - 2) + climbStairs5(n - 3);

        return arr[n];
    }

    /**
     * 每次可以爬 1、2 或 3 阶楼梯的方法（邪修，无需数组存储）
     *
     * @param n 代表 n 阶台阶
     * @return 爬 n 阶台阶的有多少种不同的方式
     */
    public static int climbStairs6(int n) {
        // 第 n 阶台阶（n>2）,一定是从 n-1 阶台阶和 n-2 阶台阶走来的
        // 那么走第 n 阶台阶的走法，就是 n-1 阶台阶的走法加上 n-2 阶台阶的走法

        int a = 1;
        if (n == 1) {
            return a;
        }
        int b = 2;
        if (n == 2) {
            return b;
        }
        int c = 3;
        if (n == 3) {
            return c;
        }
        int d = 0;
        for (int i = 4; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}
