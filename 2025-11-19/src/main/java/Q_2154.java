import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-19
 * @Description:
 * @Version: 1.0
 */
public class Q_2154 {
    public static void main(String[] args) {
        // case1
        int[] nums = {5,3,6,1,12};
        int original = 3;
        int res = findFinalValue(nums, original);
        // 24
        System.out.println(res);

        // case2
//        int[] nums = {2, 7, 9};
//        int original = 4;
//        int res = findFinalValue(nums, original);
//        // 4
//        System.out.println(res);
    }

    public static int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int n = nums.length;
        int index = 0;
        while (index < n) {
            if (nums[index++] == original) {
                original *= 2;
            }
        }
        return original;
    }
}
