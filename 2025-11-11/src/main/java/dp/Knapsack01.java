package dp;


/**
 * @Author: sangui
 * @CreateTime: 2025-11-11
 * @Description: 0-1 背包
 * @Version: 1.0
 */
public class Knapsack01 {
    // static int[][] dp = new int[4 + 1][10 + 1];
    static int[] dp = new int[10 + 1];


    static void main() {
        // 有 n 件物品，第 i 件重量 wt[i]，价值 val[i]，背包容量 W。
        // 每件物品最多取 1 次（要么取，要么不取）。
        // 求在不超过容量 W 的前提下，能获得的最大总价值是多少？
        // 并演示如何恢复出被选择的物品集合。

        // 重量
        int[] wt = {3, 4, 6, 5};
        // 价值
        int[] val = {2, 3, 1, 4};
        // 容量
        int W = 10;
        // 计算最大价值
        int res = knapsackWithChoice(wt, val, W);
        // 输出
        System.out.println("计算得出最大的背包价值：" + res);
    }

//    public static int knapsackWithChoice(int[] wt, int[] val, int W) {
//        // i 代表第 i 件物品，i 从 1 开始。
//        for (int i = 1; i <= wt.length; i++) {
//            // 第 i 件物品的重量
//            int wt_i = wt[i - 1];
//            // 第 i 件物品的价值
//            int val_i = val[i - 1];
//            // w 代表背包容量，从 0 开始计算,一直到我们的真正的背包容量：W
//            for (int w = 0; w <= W; w++) {
//                // 若 背包容量 w 小于 第 i 件物品的重量，代表不能放
//                if (w < wt_i) {
//                    // 不能放，该价值等于上一件物品这时的价值
//                    dp[i][w] = dp[i - 1][w];
//                } else {
//                    // 走到这里，说明背包有空闲重量，可放，可不放，需要比较这两个值
//                    // 该价值等于 没加这件物品的价值(dp[i - 1][w - wt_i]) + 这件物品的价值(val_i)
//                    dp[i][w] = Math.max(dp[i - 1][w - wt_i] + val_i, dp[i - 1][w]);
//                }
//            }
//        }
//        System.out.println("具体 dp 矩阵:------------------");
//        for (int i = 0; i <= 4; i++) {
//            for (int j = 0; j <= 10; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("------------------------------");
//        for (int i = 4; i >= 1; i--) {
//            if (dp[i][W] != dp[i - 1][W]) {
//                System.out.println("第 " + i + " 件物品被选！");
//                W -= wt[i - 1];
//            }
//        }
//        return dp[4][10];
//    }

    public static int knapsackWithChoice(int[] wt, int[] val, int W) {
        // i 代表第 i 件物品，i 从 1 开始。
        for (int i = 1; i <= 4; i++) {
            // 第 i 件物品的重量
            int wt_i = wt[i - 1];
            // 第 i 件物品的价值
            int val_i = val[i - 1];
            for (int w = W; w >= wt[i-1]; w--) {
                dp[w] = Math.max(dp[w], dp[w - wt_i] + val_i);
            }
        }
        System.out.println("具体 dp 矩阵:------------------");
        for (int i = 0; i <= 10; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        System.out.println("------------------------------");

        return dp[10];
    }
}
