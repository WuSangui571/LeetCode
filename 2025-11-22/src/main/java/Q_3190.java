/**
 * @Author: sangui
 * @CreateTime: 2025-11-22
 * @Description:
 * @Version: 1.0
 */
public class Q_3190 {
    public static void main(String[] args) {
        // case1
        int[] nums = {1,2,3,4};
        int res = minimumOperations(nums);
        // 3
        System.out.println(res);

        // case2
//        int[] nums = {3,6,9};
//        int res = minimumOperations(nums);
//        // 0
//        System.out.println(res);
    }

    public static int minimumOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int item = nums[i];
            if (item %3 !=0){
                count++;
            }
        }
        return count;
    }
}
