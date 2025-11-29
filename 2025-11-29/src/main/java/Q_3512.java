/**
 * @Author: sangui
 * @CreateTime: 2025-11-29
 * @Description:
 * @Version: 1.0
 */
public class Q_3512 {
    public static void main(String[] args) {
        // case1
//        int[] nums = {3,9,7};
//        int k = 5;
//        int res = minOperations(nums, k);
//        // 4
//        System.out.println(res);

        // case2
//        int[] nums = {4,1,3};
//        int k = 4;
//        int res = minOperations(nums, k);
//        // 0
//        System.out.println(res);

        // case3
        int[] nums = {3,2};
        int k = 6;
        int res = minOperations(nums, k);
        // 5
        System.out.println(res);

    }
    public static int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum % k;
    }
}
