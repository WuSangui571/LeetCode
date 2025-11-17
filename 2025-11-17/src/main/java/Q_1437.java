/**
 * @Author: sangui
 * @CreateTime: 2025-11-17
 * @Description:
 * @Version: 1.0
 */
public class Q_1437 {
    public static void main(String[] args) {
        System.out.println(1);
        // case1
//        int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
//        int k = 2;
//        boolean res = kLengthApart(nums, k);
//        // true
//        System.out.println(res);

        // case2
//        int[] nums = {1,0,0,1,0,1};
//        int k = 2;
//        boolean res = kLengthApart(nums,k);
//        // false
//        System.out.println(res);

    }

    public static boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int firstOneIndex = -1;
        for (int i = 0; i < n; i++) {
            int item = nums[i];
            if (item == 1) {
                firstOneIndex = i;
                break;
            }
        }
        if (firstOneIndex == -1) {
            return true;
        }
        int count = 0;
        for (int i = firstOneIndex; i < n; i++) {
            int item = nums[i];
            if (item == 1) {
                if (count < k) {
                    if (i != firstOneIndex) {
                        return false;
                    }
                }
            } else {
                count++;
            }
        }
        return true;
    }
}
