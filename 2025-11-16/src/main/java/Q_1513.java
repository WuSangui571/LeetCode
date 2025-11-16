/**
 * @Author: sangui
 * @CreateTime: 2025-11-16
 * @Description:
 * @Version: 1.0
 */
public class Q_1513 {
    public static void main(String[] args) {
//        System.out.println(f(4));

        // case1
//        String s = "0110111";
//        int res = numSub(s);
//        // 9
//        System.out.println(res);

        // case2
//        String s = "101";
//        int res = numSub(s);
//        // 2
//        System.out.println(res);

        // case3
//        String s = "111111";
//        int res = numSub(s);
//        // 21
//        System.out.println(res);

        // case4
//        String s = "000";
//        int res = numSub(s);
//        // 0
//        System.out.println(res);

        System.out.println(f(80000));
    }

    public static int numSub(String s) {
        int count = 0;
        long res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                count++;
            } else if (count != 0) {
                System.out.print("f(" + count + ")=");
                System.out.print(f(count));
                System.out.print(",res = ");
                System.out.print(res);
                res += f(count);
                count = 0;
            }
        }
        if (count != 0) {
            res += f(count);

        }
        return (int) (res % 1000000007);
    }

    public static long f(long number) {
//        System.out.print("f(" + number + ")=");
//        System.out.println((1 + number) * number / 2);
        return (1 + number) * number / 2;
    }
}
