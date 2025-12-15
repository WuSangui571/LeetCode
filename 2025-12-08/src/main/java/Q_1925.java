/**
 * @Author: sangui
 * @CreateTime: 2025-12-08
 * @Description:
 * @Version: 1.0
 */
public class Q_1925 {
    public static int[] np = new int[251];

    public static void main(String[] args) {
        // case1
//        Q_1925 obj = new Q_1925();
//        int n = 5;
//        int res = obj.countTriples(n);
//        // 2
//        System.out.println(res);

        // case2
//        Q_1925 obj = new Q_1925();
//        int n = 10;
//        int res = obj.countTriples(n);
//        // 4
//        System.out.println(res);

        // case3
        Q_1925 obj = new Q_1925();
        int n = 18;
        int res = obj.countTriples(n);
        // 4
        //System.out.println(res);
        for (int i = 1; i <= n; i++) {
            System.out.println("np[" + i + "] = " + np[i]);
        }
    }

    public int countTriples(int n) {
        np[5] = 1;
        if (np[n] == 0) {
            f(n);
        }
        return 2 * np[n];
    }

    public static void f(int n) {
        if (n <= 4) {
            return;
        }
        if (np[n] != 0) {
            return;
        }
        int temp = 0;
        for (int i = n; i >= 5; i--) {
            if (np[i] != 0) {
                temp = i;
                break;
            }
        }
        int b = temp ;
        for (int a = temp - 1; a <= n - 2; a++) {
            int tempRes = a * a + b * b;
            int c = (int) Math.sqrt(tempRes);
            if (c > n) {
                continue;
            }
            boolean isPerfectSquare = (c * c == tempRes);
            System.out.println("a = " + a + ", b = " + b + ",c = " + c + ",是否是？ " + isPerfectSquare);
            if (isPerfectSquare) {
                np[c] = np[c - 1] + 1;
                System.out.println("np[" + c + "] = np[" + (c - 1) + "] + 1 = " + (np[c - 1] + 1));
                b = a + 2;
                a--;

            } else {
                if (np[c] == 0) {
                    np[c] = np[c - 1];
                    System.out.println("np[" + c + "] = np[" + (c - 1) + "] = " + np[c - 1]);
                }
                b++;
                if (b == n - 1) {
                    b = a + 2;
                } else {
                    a--;
                }
            }
        }
        for (int i = 5; i <= n; i++) {
            if (np[n] == 0) {
                np[n] = np[n - 1];
                System.out.println("np[" + n + "] = np[" + (n - 1) + "] = " + np[n - 1]);
            }
        }
    }
}
