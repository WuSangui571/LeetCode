import java.util.*;

/**
 * @Author: sangui
 * @CreateTime: 2026-01-13
 * @Description:
 * @Version: 1.0
 */
public class Q3453 {
    public static void main(String[] args) {
        // 1.00000
//        int[][] squares = {{0, 0, 1}, {2, 2, 1}};
//        int[][] squares = {{2, 2, 1}, {0, 0, 1},};

        // 1.16667
        int[][] squares = {{0, 0, 2}, {1, 1, 1}};


        Q3453 obj = new Q3453();
        double res = obj.separateSquares(squares);
        System.out.println(res);
    }

    public double separateSquares(int[][] squares) {
        double totalArea = 0L;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < squares.length; i++) {
            totalArea += ((long) squares[i][2] * squares[i][2]);
            list.add(new int[]{squares[i][1], squares[i][2]});
            list.add(new int[]{squares[i][1] + squares[i][2], (-1) * squares[i][2]});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));

        double currentArea = 0L;
        double currentWidth = 0L;
        for (int i = 0; i < list.size() - 1; i++) {
            int currentY = list.get(i)[0];
            int currentL = list.get(i)[1];
            int nextY = list.get(i + 1)[0];
            currentWidth += currentL;
            double increase = currentWidth * (nextY - currentY);
            if ((increase + currentArea) >= (totalArea / 2)) {
                double missingArea = totalArea / 2 - currentArea;
                double missingY = missingArea / currentWidth;
                return currentY + missingY;
            }
            currentArea += increase;
        }
        return 0L;
    }

    public double separateSquares2(int[][] squares) {
        double totalArea = 0L;
        int n = squares.length;
//        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // add total area
            totalArea += ((long) squares[i][2] * squares[i][2]);
            list.add(new int[]{squares[i][1], squares[i][2]});
            list.add(new int[]{squares[i][1] + squares[i][2], (-1) * squares[i][2]});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        System.out.println("totalArea = " + totalArea);
        System.out.println("list = ");
        double currentArea = 0L;
        double currentWidth = 0L;
        for (int i = 0; i < list.size() - 1; i++) {
            int y = list.get(i)[0];
            int l_type = list.get(i)[1];
            System.out.println(Arrays.toString(list.get(i)));

            currentWidth += l_type;
            double increase = currentWidth * (list.get(i + 1)[0] - y);
            if ((increase + currentArea) >= (totalArea / 2)) {
                System.out.println("found in " + y + "~" + list.get(i + 1)[0]);
                double missingArea = totalArea / 2 - currentArea;
                double missingY = missingArea / currentWidth;
                return y + missingY;
            }
            currentArea += increase;
        }
        return 0L;
    }
}
