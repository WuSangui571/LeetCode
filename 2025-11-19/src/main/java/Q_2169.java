/**
 * @Author: sangui
 * @CreateTime: 2025-11-19
 * @Description:
 * @Version: 1.0
 */
public class Q_2169 {
    public static void main(String[] args) {
        // case1
        int num1 = 2;
        int num2 = 3;
        int res = countOperations(num1, num2);
        // 3
        System.out.println(res);

        // case2
//        int num1 = 10;
//        int num2 = 10;
//        int res = countOperations(num1, num2);
//        // 1
//        System.out.println(res);
    }

    public static int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2){
                num1 -= num2;
            }else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }
}
