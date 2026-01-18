/**
 * @Author: sangui
 * @CreateTime: 2026-01-18
 * @Description:
 * @Version: 1.0
 */
public class PrefixSum2 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        int firstRowIndex = 2;
        int firstColumnIndex = 1;
        int lastRowIndex = 3;
        int lastColumnIndex = 3;
        int res = f(grid, firstRowIndex, firstColumnIndex, lastRowIndex, lastColumnIndex);
        System.out.println(res);
    }

    public static int f(int[][] grid, int firstRowIndex, int firstColumnIndex, int lastRowIndex, int lastColumnIndex) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] p = new int[m + 1][n + 1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                p[r + 1][c + 1] = (grid[r][c] + p[r][c + 1] + p[r + 1][c] - p[r][c]);
            }
        }
        return p[lastRowIndex+1][lastColumnIndex+1] - p[firstRowIndex][lastColumnIndex+1] - p[lastRowIndex+1][firstColumnIndex] + p[firstRowIndex][firstColumnIndex];
    }
}
