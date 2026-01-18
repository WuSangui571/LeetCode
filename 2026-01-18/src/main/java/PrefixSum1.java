/**
 * @Author: sangui
 * @CreateTime: 2026-01-18
 * @Description:
 * @Version: 1.0
 */
public class PrefixSum1 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 3, 2};
        int firstIndex = 2;
        int lastIndex = 4;
        int res = f(nums, firstIndex, lastIndex);
        System.out.println(res);
    }

    public static int f(int[] nums, int firstIndex, int lastIndex) {
        int n = nums.length;
        // p[x] 表示 nums数组中前x个数的和
        int[] p = new int[n + 1];

        for (int i = 0; i < n; i++) {
            p[i + 1] = (p[i] + nums[i]);
        }
        return p[lastIndex + 1] - p[firstIndex];
    }
}
