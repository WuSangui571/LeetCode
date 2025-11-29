/**
 * @Author: sangui
 * @CreateTime: 2025-11-27
 * @Description:
 * @Version: 1.0
 */
public class Q_3381 {
    static  long[] dp;
    public static void main(String[] args) {
        // case1
//        int[] nums = {1,2};
//        int k = 1;
//        long res = maxSubarraySum(nums, k);
//        // 3
//        System.out.println(res);

        // case2
//        int[] nums = {-1,-2,-3,-4,-5};
//        int k = 4;
//        long res = maxSubarraySum(nums, k);
//        // -10
//        System.out.println(res);

        // case3
//        int[] nums = {-5,1,2,-3,4};
//        int k = 2;
//        long res = maxSubarraySum(nums, k);
//        // 4
//        System.out.println(res);

        // case4
//        int[] nums = {-10,-1};
//        int k = 1;
//        long res = maxSubarraySum(nums, k);
//        // -1
//        System.out.println(res);

        // case5
        int[] nums = {16,-16,-12};
        int k = 1;
        long res = maxSubarraySum(nums, k);
        // 16
        System.out.println(res);

    }

    public static long maxSubarraySum(int[] nums, int k) {
        long time1 = System.currentTimeMillis();
        int n = nums.length;
        int maxLength = n - (n % k);
        //System.out.println("maxLength = " +  maxLength);
        dp = new long[n + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = nums[i] + dp[i];
            //System.out.println("dp[" + (i + 1) + "] = " + dp[i + 1]);
        }
        int index = 0;
        long maxValue = Long.MIN_VALUE;
        while (true){
            long sum = dp[index + maxLength] - dp[index];
            if(sum > maxValue){
                maxValue = sum;
            }
            if (index + maxLength < n){
                index ++;
            }else if (maxLength > k){
                maxLength -= k;
                index = 0;
            }else {
                long time2 = System.currentTimeMillis();
                System.out.println("耗时：" + (time2 - time1) + "ms");
                return maxValue;
            }
        }
    }
}
