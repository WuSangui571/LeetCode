package dp;


/**
 * @Author: sangui
 * @CreateTime: 2025-11-11
 * @Description:
 * @Version: 1.0
 */
public class Q_474 {
    static int[][][] dp;

    static void main() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int res = findMaxForm(strs, m, n);
        System.out.println(res);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length + 1][m + 1][n + 1];
        // 依次遍历每一个数组中的元素
        for (int i = 1; i <= strs.length; i++) {
            int[] arr = f(strs[i - 1]);
            int countZero = arr[0];
            int countOne = arr[1];
            // m 代表 0 的容量，依次遍历
            for (int j = 0; j <= m; j++) {
                // n 代表 1 的容量，依次遍历
                for (int k = 0; k <= n; k++) {
                    if (j < countZero || k < countOne) {
                        // 走到这里，说明背包没有空闲，不可放
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        // 走到这里，说明背包有空闲，可放，可不放，需要比较这两个值
                        dp[i][j][k] = Math.max(dp[i - 1][j - countZero][k - countOne] + 1, dp[i - 1][j][k]);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public static int[] f(String str) {
        int[] res = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            res[str.charAt(i) - '0']++;
        }
        return res;
    }
}
