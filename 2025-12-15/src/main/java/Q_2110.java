/**
 * @Author: sangui
 * @CreateTime: 2025-12-15
 * @Description:
 * @Version: 1.0
 */
public class Q_2110 {
    public static void main(String[] args) {
        // case1
        int[] prices = {3, 2, 1, 4};
        Q_2110 obj = new Q_2110();
        long res = obj.getDescentPeriods(prices);
        // 7
        System.out.println(res);

        // case2
//        int[] prices = {8,6,7,7};
//        Q_2110 obj = new Q_2110();
//        long res = obj.getDescentPeriods(prices);
//        // 4
//        System.out.println(res);

        // case3
//        int[] prices = {1};
//        Q_2110 obj = new Q_2110();
//        long res = obj.getDescentPeriods(prices);
//        // 1
//        System.out.println(res);
    }

    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 1;
        }
        long res = n;
        long count = 1;
        for (int i = 1; i < prices.length; i++) {

            if ((prices[i] + 1) == prices[i - 1]) {
                count++;
                if (i == prices.length - 1) {
                    res += f(count);
                }
            } else if (count != 0) {
                res += f(count);
                count = 1;
            }
        }
        return res;
    }
    public long f(long num){
        //System.out.println("count(" + num + ") ");
        return num*(num-1)/2;
    }
}
