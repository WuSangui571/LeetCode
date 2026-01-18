import java.sql.SQLOutput;

/**
 * @Author: sangui
 * @CreateTime: 2026-01-18
 * @Description:
 * @Version: 1.0
 */
public class Q1895 {
    public static void main(String[] args) {
        // 3
        int[][] grid = {{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}};

        // 2
//        int[][] grid = {{5,1,3,1},{9,3,3,1{,}1,3,3,8}};

        Q1895 obj = new Q1895();
        int res = obj.largestMagicSquare2(grid);
//        boolean res = obj.isMagicSquare(grid,1,1,3);
        System.out.println(res);
    }

    public int largestMagicSquare2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // k 的最大值
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int r = 0; r <= m - k; r++) {
                for (int c = 0; c <= n - k; c++) {
//                    System.out.println("r=" + r + ",c=" + c + ",k=" + k);
                    if (isMagicSquare2(grid,r,c,k)){
                        return k;
                    }
                }
            }
        }
        return 1;
    }

    /**
     *
     * @param grid 题目的大矩阵
     * @param r    左上角的行数
     * @param c    左上角的列数
     * @param k    边长
     * @return 分隔的小矩阵是否是幻方
     */
    public boolean isMagicSquare2(int[][] grid, int r, int c, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // 判断是否越界
        if ((r + k > m) || (c + k > n)) {
            return false;
        }
        int value = 0;
        int temp = 0;
        // 计算第一行作为 value
        for (int j = c; j < (c + k); j++) {
            value += grid[r][j];
        }
        // 横向（行）
        for (int i = r + 1; i < (r + k); i++) {
            for (int j = c; j < (c + k); j++) {
                temp += grid[i][j];
            }
            if (temp != value) {
                return false;
            } else {
                temp = 0;
            }
        }
        // 竖向（列）
        for (int j = c; j < (c + k); j++) {
            for (int i = r; i < (r + k); i++) {
                temp += grid[i][j];
            }
            if (temp != value) {
                return false;
            } else {
                temp = 0;
            }
        }
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
