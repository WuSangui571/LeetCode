import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-12-30
 * @Description:
 * @Version: 1.0
 */
public class Q_840 {
    public static void main(String[] args) {
        Q_840 obj = new Q_840();
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2},{4,3,8,4},{9,5,1,9},{2,7,6,2}};
//        int[][] grid = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
//        int[][] grid = {{5,5,5},{5,5,5},{5,5,5}};
        int res = obj.numMagicSquaresInside(grid);
        // 1
        System.out.println(res);
    }

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        System.out.println("m = " + m + ", n = " + n);
        if (m < 3 || n < 3) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        while (((j + 3) <= n) && ((i + 3) <= m)) {
            System.out.print("i = " + i + ", j = " + j + " -> ");
            count += f(grid[i][j], grid[i][j + 1], grid[i][j + 2],
                    grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                    grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2]);
            if (j == n - 3) {
                j = 0;
                i++;
            } else {
                j++;
            }
            System.out.println("i = " + i + ", j = " + j);
        }
        return count;
    }

    public int f(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        int temp = 362880;
        int temp2 = 45;
        try {
            if (a + b + c + d + e + f + g + h + i != temp2) {
                return 0;
            }
            if (a * b * c * d * e * f * g * h * i != temp) {
                return 0;
            }
        } catch (Exception fff) {
            return 0;
        }

        // 横
        int constValue = a + b + c;
        if ((d + e + f) != constValue || (g + h + i) != constValue) {
            return 0;
        }
        // 竖
        if ((a + d + g) != constValue || (b + e + h) != constValue || (c + f + i) != constValue) {
            return 0;
        }
        // 撇
        if ((c + e + g) != constValue) {
            return 0;
        }
        // 捺
        if ((a + e + i) != constValue) {
            return 0;
        }
        return 1;
    }
}
