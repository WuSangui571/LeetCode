import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-14
 * @Description:
 * @Version: 1.0
 */
public class Q_303 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        NumArray obj = new NumArray(nums);

        // case1
//        int left = 0;
//        int right = 2;
//        int res = obj.sumRange(left, right);
//        // 1
//        System.out.println(res);

        // case2
//        int left = 2;
//        int right = 5;
//        int res = obj.sumRange(left, right);
//        // -1
//        System.out.println(res);

        // case3
        int left = 1;
        int right = 5;
        int res = obj.sumRange(left, right);
        // -3
        System.out.println(res);
    }

    static class NumArray {
        int[] prefix;

        public NumArray(int[] nums) {
            int n = nums.length;
            this.prefix = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            System.out.println(Arrays.toString(prefix));
        }
//        public NumArray(int[] nums) {
//            int n = nums.length;
//            this.prefix = new int[n];
//            prefix[0] = nums[0];
//            for (int i = 1; i < n; i++) {
//                prefix[i ] = prefix[i-1] + nums[i];
//            }
//            System.out.println(Arrays.toString(prefix));
//        }

        public int sumRange(int left, int right) {
            return prefix[right+1] - prefix[left];
        }
    }
}
