import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-14
 * @Description:
 * @Version: 1.0
 */
public class Q_304 {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);

        // case1
        int res = obj.sumRegion(2, 1, 4, 3);
        // 8
        System.out.println(res);

        // case2
//        int res = obj.sumRegion(2,1,4,3);
//        // 8
//        System.out.println(res);

        // case3
//        int res = obj.sumRegion(1,1,2,2);
//        // 11
//        System.out.println(res);

        // case4
//        int res = obj.sumRegion(1,2,2,4);
//        // 12
//        System.out.println(res);
    }

    static class NumMatrix {
        int[][] prefix;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            prefix = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                int lineCount = 0;
                for (int j = 1; j <= n; j++) {
                    lineCount += matrix[i - 1][j - 1];
                    prefix[i][j] = prefix[i - 1][j] + lineCount;
                }
            }
            System.out.println(Arrays.deepToString(prefix));
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefix[row2 + 1][col2 + 1] + prefix[row1][col1]-prefix[row1][col2+1]-prefix[row2+1][col1];
        }
    }
}
