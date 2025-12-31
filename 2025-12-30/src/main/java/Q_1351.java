/**
 * @Author: sangui
 * @CreateTime: 2025-12-30
 * @Description:
 * @Version: 1.0
 */
public class Q_1351 {
    public static void main(String[] args) {
        Q_1351 obj = new Q_1351();
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int res = obj.countNegatives(grid);
        // 8
        System.out.println(res);
    }

    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rightI = m - 1;
        int rightJ = n - 1;
        int leftI = m - Math.min(m, n);
        int leftJ = n - Math.min(m, n);
        while(leftI < rightI){
            int midI = (leftI + rightI)/2;
            int midJ = (leftJ + rightJ)/2;
            if (grid[midI][midJ] < 0){
                rightI = midI - 1;
                rightJ = midJ - 1;
            }else {
                leftI = midI + 1;
                leftJ = midJ + 1;
            }
        }
        System.out.println("leftI = " + leftI + ",leftJ = " + leftJ);
        System.out.println("rightI = " + rightI + ",rightJ = " + rightJ);
        int count = 0;
        // 矩形
        System.out.println("矩形面积 = " + (m-leftI) +" * " + (n - leftJ));
        count += ((m-leftI)*(n - leftJ));
        // 横
        for (int i = rightI; i < m; i++) {
            if (grid[i][rightJ] < 0){
                System.out.println("横着有 = " + (m-i));
                count += (m-i);
                break;
            }
        }
        // 竖
        for (int j = rightJ; j < n; j++) {
            if (grid[rightJ][j] < 0){
                System.out.println("竖着有 = " + (n-j));
                count += (n-j);
                break;
            }
        }
        return count;
    }
}
