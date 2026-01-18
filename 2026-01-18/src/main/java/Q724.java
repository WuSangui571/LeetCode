/**
 * @Author: sangui
 * @CreateTime: 2026-01-18
 * @Description:
 * @Version: 1.0
 */
public class Q724 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        Q724 q724 = new Q724();
        int res = q724.pivotIndex(nums);
        System.out.println(res);
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        // p[x] 表示 nums数组中前x个数的和
        int[] p = new int[n + 1];

        for (int i = 0; i < n; i++) {
            p[i + 1] = (p[i] + nums[i]);
        }
        int leftSum = 0;
        int rightSum = 0;
        // i 是中心下标
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum = p[i] - p[0];
            }
            if (i == n - 1) {
                rightSum = 0;
            } else {
                rightSum = p[n] - p[i+1];
            }
//            System.out.println("leftSum=" + leftSum + ",rightSum=" + rightSum);
            if (leftSum == rightSum) {
                return i;
            }
        }
//        return p[lastIndex + 1] - p[firstIndex];

        return -1;
    }
}
