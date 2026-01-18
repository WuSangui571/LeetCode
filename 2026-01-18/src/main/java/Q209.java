/**
 * @Author: sangui
 * @CreateTime: 2026-01-18
 * @Description:
 * @Version: 1.0
 */
public class Q209 {
    int[] p;

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        Q209 obj = new Q209();
        int res = obj.minSubArrayLen(target, nums);
        System.out.println(res);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        // 特殊情况
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > target){
                return 1;
            }
            sum += nums[i];
        }
        if (sum < target){
            return 0;
        }

        p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = (p[i] + nums[i]);
        }
        // 定义 len 为子数组长度
        for (int len = 1; len <= n; len++) {
            // 定义 i 为子数组的开始坐标
            for (int i = 0; i <= (n - len); i++) {
                if ((p[i + len] - p[i])>= target){
                    return len;
                }
            }
        }
        return 0;
    }
}
