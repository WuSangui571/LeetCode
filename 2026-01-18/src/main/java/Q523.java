/**
 * @Author: sangui
 * @CreateTime: 2026-01-18
 * @Description:
 * @Version: 1.0
 */
public class Q523 {
    public static void main(String[] args) {
        int[] nums = {123, 2, 4, 6, 7};
//        int[] nums = {6};
        int k = 6;
        Q523 q523 = new Q523();
        boolean res = q523.checkSubarraySum(nums, k);
        System.out.println(res);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // p[x] 表示 nums数组中前x个数的和
        int[] p = new int[n + 1];

        for (int i = 0; i < n; i++) {
            p[i + 1] = (p[i] + nums[i]);
        }
//        return p[lastIndex + 1] - p[firstIndex];
        for (int step = n; step >= 2; step--) {
            for (int firstIndex = 0; firstIndex <= n - step; firstIndex++) {
                int sum = p[firstIndex + step] - p[firstIndex];
                if (k == 0 || sum % k == 0 || sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
