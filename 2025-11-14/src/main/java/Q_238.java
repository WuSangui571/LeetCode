import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-14
 * @Description:
 * @Version: 1.0
 */
public class Q_238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf2(nums);
        // [24,12,8,6]
        System.out.println(Arrays.toString(res));

//        int[] nums = {-1, 1, 0, -3, 3};
//        int[] res = productExceptSelf(nums);
//        // [0,0,9,0,0]
//        System.out.println(Arrays.toString(res));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        System.out.println("left:" + Arrays.toString(left));

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        System.out.println("right:" + Arrays.toString(right));
        return res;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        System.out.println("res:" + Arrays.toString(res));

        int rightValue = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightValue *= nums[i + 1];
            res[i] *= rightValue;
        }
        return res;
    }
}
