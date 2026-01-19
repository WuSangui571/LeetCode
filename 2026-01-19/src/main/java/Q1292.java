/**
 * @Author: sangui
 * @CreateTime: 2026-01-19
 * @Description:
 * @Version: 1.0
 */
public class Q1292 {
    public static void main(String[] args) {
        // 2
        int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int threshold = 4;
        Q1292 q1292 = new Q1292();
        int res = q1292.maxSideLength(mat, threshold);
        System.out.println(res);
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] p = new int[m + 1][n + 1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                p[r + 1][c + 1] = (mat[r][c] + p[r][c + 1] + p[r + 1][c] - p[r][c]);
            }
        }
        for (int step = Math.max(m, n); step >= 0; step--) {
            for (int firstRowIndex = 0; firstRowIndex <= m - step; firstRowIndex++) {
                for (int firstColumnIndex = 0; firstColumnIndex <= n - step; firstColumnIndex++) {
                    if ((p[firstRowIndex + step][firstColumnIndex + step] - p[firstRowIndex][firstColumnIndex + step] - p[firstRowIndex + step][firstColumnIndex] + p[firstRowIndex][firstColumnIndex]) <= threshold) {
                        return step;
                    }
                }
            }
        }
//        return p[lastRowIndex+1][lastColumnIndex+1] - p[firstRowIndex][lastColumnIndex+1] - p[lastRowIndex+1][firstColumnIndex] + p[firstRowIndex][firstColumnIndex];
        return 0;
    }
}
