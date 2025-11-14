import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-14
 * @Description:
 * @Version: 1.0
 */
public class Q_2536 {
    public static void main(String[] args) {
        // case1
//        int n = 3;
//        int[][] queries = {{1, 1, 2, 2}, {0, 0, 1, 1}};
//        int[][] res = rangeAddQueries(n, queries);
//        // 预计输出：[[1,1,0],[1,2,1],[0,1,1]]
//        System.out.println(Arrays.deepToString(res));

        // case2
        int n = 2;
        int[][] queries = {{0, 0, 1, 1}};
        int[][] res = rangeAddQueries(n, queries);
        // 预计输出：[[1,1],[1,1]]
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        int[][] diff = new int[n + 1][n + 1];

        for (int[] singleQuery : queries) {
            int x1 = singleQuery[0] + 1;
            int y1 = singleQuery[1] + 1;
            int x2 = singleQuery[2] + 1;
            int y2 = singleQuery[3] + 1;

            // 大矩形
            diff[x2][y2]++;
            // 左边的一个小矩形
            diff[x2][y1 - 1]--;
            // 上边的另一个小矩形
            diff[x1 - 1][y2]--;

            // 多减去的右下角矩形，要恢复，即++
            diff[x1 - 1][y1 - 1]++;
        }
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (i != n) {
                    diff[i][j] += diff[i + 1][j];
                }
                if (j != n) {
                    diff[i][j] += diff[i][j + 1];
                }
                if (j != n && i != n) {
                    diff[i][j] -= diff[i + 1][j + 1];
                }
                res[i - 1][j - 1] = diff[i][j];
            }
        }

        return res;
    }
}
