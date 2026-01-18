import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2026-01-18
 * @Description:
 * @Version: 1.0
 */
public class Q1895PrefixSum {
    int[][] p;
    public static void main(String[] args) {
        // 3
        int[][] grid = {{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}};

        // 2
//        int[][] grid = {{5,1,3,1},{9,3,3,1{,}1,3,3,8}};

        Q1895PrefixSum obj = new Q1895PrefixSum();
        int res = obj.largestMagicSquare(grid);
//        boolean res = obj.isMagicSquare(grid,1,1,3);
        System.out.println(res);
    }
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m + 1][n + 1];
        // 计算前缀和数组
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                p[r + 1][c + 1] = (grid[r][c] + p[r][c + 1] + p[r + 1][c] - p[r][c]);
            }
        }
        System.out.println(Arrays.deepToString(p));
        // k 的最大值
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int r = 0; r <= m - k; r++) {
                for (int c = 0; c <= n - k; c++) {
//                    System.out.println("r=" + r + ",c=" + c + ",k=" + k);
                    if (isMagicSquare(grid,r,c,k)){
                        return k;
                    }
                }
            }
        }
        return 1;
    }
    public boolean isMagicSquare(int[][] grid, int r, int c, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // 判断是否越界
        if ((r + k > m) || (c + k > n)) {
            return false;
        }
        // 计算第一行作为 value
        int value = p[r+1][c+k] - p[r][c+k] - p[r+1][c] + p[r][c];
        int temp = 0;

        // 横向（行）
        for (int i = r + 1; i < (r + k); i++) {
            temp = p[i+1][c+k] - p[i][c+k] - p[i+1][c] + p[i][c];
            if (temp != value) {
                return false;
            }
        }
        // 竖向（列）
        for (int j = c; j < (c + k); j++) {
            temp = p[r+k][j+1] - p[r][j+1] - p[r+k][j] + p[r][j];;
            if (temp != value) {
                return false;
            }
        }
        temp = 0;
        // 撇向对角线
        for (int i = r; i < (r + k); i++) {
            int j = c + k - i + r - 1;
            temp += grid[i][j];
        }
        if (temp != value) {
            return false;
        } else {
            temp = 0;
        }
        // 捺向对角线
        for (int i = r; i < (r + k); i++) {
            int j = c + i - r;
            temp += grid[i][j];
        }
        if (temp != value) {
            return false;
        }

        return true;
    }
}
