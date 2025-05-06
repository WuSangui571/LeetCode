import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-06
 * @Description: buildArray
 * @Version: 1.0
 */
public class Q_1920 {
    public static void main(String[] args) {
        int nums[] = new int[6];
        nums[0] = 5;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 2;
        nums[4] = 3;
        nums[5] = 4;
        System.out.println(Arrays.toString(f(nums)));
    }
    public static int[] f(int[] nums) {
        int base = 1000;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += (nums[nums[i] % base] % base * base);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] /base;
        }
        return nums;
    }
}
