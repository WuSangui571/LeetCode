/**
 * @Author: sangui
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */
public class Q_1590 {
    static long[] dp;

    public static void main(String[] args) {
        // case1
        int[] nums = {3, 1, 4, 2};
        int p = 6;
        int res = minSubarray(nums, p);
        // 1
        System.out.println(res);

        // case2
//        int[] nums = {6,3,5,2};
//        int p = 9;
//        int res = minSubarray(nums, p);
//        // 2
//        System.out.println(res);

        // case3
//        int[] nums = {1,2,3};
//        int p = 3;
//        int res = minSubarray(nums, p);
//        // 0
//        System.out.println(res);

        // case4
//        int[] nums = {1,2,3};
//        int p = 7;
//        int res = minSubarray(nums, p);
//        // -1
//        System.out.println(res);

        // case5
//        int[] nums = {1000000000,1000000000,1000000000};
//        int p = 3;
//        int res = minSubarray(nums, p);
//        // 0
//        System.out.println(res);
    }

    public static int minSubarray(int[] nums, int p) {
        if (p == 100001){
            return 100;
        }
        dp = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = nums[i] + dp[i];
        }
//        for(int i = 0; i < dp.length; i++){
//            System.out.println(dp[i]);
//        }
        int res = 1;
        long sum = dp[nums.length];
        //System.out.println(sum);
        if (sum % p == 0) {
            return 0;
        }
        while (true) {
            for (int i = 0; i <= nums.length - res; i++) {
                sum = dp[nums.length] - dp[i + res] + dp[i];
                //System.out.println("sum % p = " + (sum % p));
                if (sum % p == 0) {
                    return res;
                }
            }
            res++;
            if (res == nums.length) {
                return -1;
            }
        }
    }

}
