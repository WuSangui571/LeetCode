import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-12-02
 * @Description:
 * @Version: 1.0
 */
public class Q_3623 {
    public static void main(String[] args) {
        // case1
//        int[][] points = {{1, 0}, {2, 0}, {3, 0}, {2, 2}, {3, 2}};
//        int res = countTrapezoids(points);
//        // 3
//        System.out.println(res);

        // case2
        int[][] points = {{0,0},{1,0},{0,1},{2,1}};
        int res = countTrapezoids(points);
        // 1
        System.out.println(res);
    }

    public static int countTrapezoids(int[][] points) {
        int res = 1;
        boolean flag = false;
        boolean flag2 = false;
        int pointCount = points.length;
        System.out.println("点的数量 =「" + pointCount + "」个");
        LinkedList<int[]> list = new LinkedList<>(Arrays.asList(points));
        System.out.println(Arrays.deepToString(list.toArray()));
        while (list.size() > 1) {
            int[] item = list.removeFirst();
            //System.out.println(item[0] + " " + item[1]);
            int y = item[1];
            int count = 1;
            Iterator<int[]> it = list.iterator();
            while (it.hasNext()) {
                int[] item2 = it.next();
                if (y == item2[1]) {
                    count++;
                    //System.out.println("count +1!");
                    it.remove();
                }
            }
            if (count >= 2) {
                if (flag){
                    flag2 = true;
                }else {
                    flag = true;
                }

//                System.out.println("count:" + count);
//                System.out.println("f():" + f(count));
                res *= f(count);
            }
        }
        return flag2?res:0;
    }
    public static int f(int num) {
        if (num == 2){
            return 1;
        }
        if (num == 3){
            return 3;
        }else {
            return f(num - 1) + num - 1;
        }
    }
}
