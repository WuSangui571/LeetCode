import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-17
 * @Description: sortColors
 * @Version: 1.0
 */
public class Q_75 {
    public static void main(String[] args) {
        // [0,0,1,1,2,2]
        //int nums[] = new int[]{2,0,2,1,1,0};
        //System.out.println("old:" + Arrays.toString(nums));
        int nums[] = new int[]{2,0,1};
        //int nums[] = new int[]{0,1};
        System.out.println("new:" + Arrays.toString(f(nums)));
    }
    public static int[] f(int[] nums) {
        int n = nums.length;
        int cur = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0){
                if (nums[cur] != 0){
                    // 交换
                    temp = nums[i];
                    nums[i] = nums[cur];
                    nums[cur] = temp;
                    cur++;
                }else {
                    cur++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1){
                if (nums[cur] != 1){
                    // 交换
                    temp = nums[i];
                    nums[i] = nums[cur];
                    nums[cur] = temp;
                    cur++;
                }else {
                    cur++;
                }

            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 2){
                if (nums[cur] != 2){
                    // 交换
                    temp = nums[i];
                    nums[i] = nums[cur];
                    nums[cur] = temp;
                    cur++;
                }else {
                    cur++;
                }
            }
        }

        return nums;
//        int n = nums.length;
//        int cur = nums.length - 1;
//        int temp;
//        for (int i = n - 1; i >= 0; i--) {
//            if (nums[i] == 2){
//                if (nums[cur] != 2){
//                    // 交换
//                    temp = nums[i];
//                    nums[i] = nums[cur];
//                    nums[cur] = temp;
//                    cur--;
//                }else {
//                    cur--;
//                }
//            }
//        }
//        for (int i = n - 1; i >= 0; i--) {
//            if (nums[i] == 1){
//                if (nums[cur] != 1){
//                    // 交换
//                    temp = nums[i];
//                    nums[i] = nums[cur];
//                    nums[cur] = temp;
//                    cur--;
//                }else {
//                    cur--;
//                }
//            }
//        }
//        for (int i = n - 1; i >= 0; i--) {
//            if (nums[i] == 0){
//                if (nums[cur] != 0){
//                    // 交换
//                    temp = nums[i];
//                    nums[i] = nums[cur];
//                    nums[cur] = temp;
//                    cur--;
//                } else {
//                    cur--;
//                }
//            }
//        }
//
//        return nums;
    }
}
