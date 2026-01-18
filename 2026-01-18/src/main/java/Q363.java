/**
 * @Author: sangui
 * @CreateTime: 2026-01-18
 * @Description:
 * @Version: 1.0
 */
public class Q363 {
    int[][] p;

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;
        Q363 obj = new Q363();
        int res = obj.maxSumSubmatrix(matrix, k);
        System.out.println(res);
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        p = new int[m + 1][n + 1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                p[r + 1][c + 1] = (matrix[r][c] + p[r][c + 1] + p[r + 1][c] - p[r][c]);
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for (int firstRowIndex = 0; firstRowIndex < m; firstRowIndex++) {
            for (int firstColumnIndex = 0; firstColumnIndex < n; firstColumnIndex++) {
                for (int rowStep = 1; rowStep <= 100; rowStep++) {
                    for (int columnStep = 1; columnStep <= 100; columnStep++) {
                        if (((firstRowIndex + rowStep) > m) || ((firstColumnIndex + columnStep) > n)) {
                            continue;
                        }
                        int tempValue = p[firstRowIndex+rowStep][firstColumnIndex+columnStep] - p[firstRowIndex][firstColumnIndex+columnStep] - p[firstRowIndex+rowStep][firstColumnIndex] + p[firstRowIndex][firstColumnIndex];
                        if (tempValue == k){
                            return k;
                        }else if ((tempValue < k) && (tempValue >maxValue)){
                            maxValue = tempValue;
                        }
                    }
                }
            }
        }
        return maxValue;
    }
}
