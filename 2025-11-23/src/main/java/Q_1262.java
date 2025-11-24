import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-23
 * @Description:
 * @Version: 1.0
 */
public class Q_1262 {
    public static void main(String[] args) {
        // case1
//        int[] nums = {3,6,5,1,8};
//        int res = maxSumDivThree(nums);
//        // 18
//        System.out.println(res);

        // case2
//        int[] nums = {4};
//        int res = maxSumDivThree(nums);
//        // 0
//        System.out.println(res);

        // case3
        int[] nums = {1, 2, 3, 4, 4};
        int res = maxSumDivThree(nums);
        // 12
        System.out.println(res);
    }

    public static int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
        }
        if (sum % 3 == 0){
            return sum;
        }
        return 0;
    }
}
