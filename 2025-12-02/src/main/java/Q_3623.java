/**
 * @Author: sangui
 * @CreateTime: 2025-12-02
 * @Description:
 * @Version: 1.0
 */
public class Q_3623 {
    public static void main(String[] args) {
        // case1
        int[][] points = {{1,0},{2,0},{3,0},{2,2},{3,2}};
        int res = countTrapezoids(points);
        // 3
        System.out.println(res);

        // case2
//        int[][] points = {{0,0},{1,0},{0,1},{2,1}};
//        int res = countTrapezoids(points);
//        // 1
//        System.out.println(res);
    }
    public static int countTrapezoids(int[][] points) {
        int pointCount = points.length;
        System.out.println("点的数量：「" + pointCount + "」个");
        return 0;
    }
}
