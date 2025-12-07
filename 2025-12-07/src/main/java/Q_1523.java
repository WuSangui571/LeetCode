/**
 * @Author: sangui
 * @CreateTime: 2025-12-07
 * @Description:
 * @Version: 1.0
 */
public class Q_1523 {
    public static void main(String[] args) {
        // case1
        int low = 3;
        int high = 7;
        Q_1523  q = new Q_1523();
        int res = q.countOdds(low, high);
        // 3
        System.out.println(res);

        // case2
//        int low = 8;
//        int high = 10;
//        Q_1523 q = new Q_1523();
//        int res = q.countOdds(low, high);
//        // 1
//        System.out.println(res);
    }

    public int countOdds(int low, int high) {
        if (low == high) {
            return low % 2 == 1 ? 1 : 0;
        }
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        } else {
            return (high - low) / 2 + 1;
        }
    }
}
