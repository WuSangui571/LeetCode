/**
 * @Author: sangui
 * @CreateTime: 2025-11-25
 * @Description:
 * @Version: 1.0
 */
public class Q_1015 {
    public static void main(String[] args) {
        // case1
//        int k = 1;
//        int res = smallestRepunitDivByK(k);
//        // 1
//        System.out.println(res);

        // case2
//        int k = 2;
//        int res = smallestRepunitDivByK(k);
//        // -1
//        System.out.println(res);

        // case3
//        int k = 3;
//        int res = smallestRepunitDivByK(k);
//        // 3
//        System.out.println(res);

        // case4
        int k = 17;
        int res = smallestRepunitDivByK(k);
        // 17
        System.out.println(res);
    }

    public static int smallestRepunitDivByK(int k) {
        int ge = k % 10;
        if (ge == 1 || ge == 3 || ge == 7 || ge == 9) {
            int count = 1;
            int temp = 1;
            while (true) {
                if (temp < 0) {
                    return -1;
                }
//                System.out.println("temp=" + temp);
//                System.out.println("k=" + k);
//                if ()
                if (temp % k == 0) {
                    return count;
                } else {
                    temp *= 10;
                    temp += 1;
                    count++;
                }
            }
        } else {
            return -1;
        }
    }
}
