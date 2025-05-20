import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-20
 * @Description: isZeroArray
 * @Version: 1.0
 */
public class Q_3355 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,0,1};
        int queries[][] = new int[][]{{0,2}};
        // true
        // [0, 0, 0]
        System.out.println(f(nums, queries));

//        int nums[] = new int[]{4,3,2,1};
//        int queries[][] = new int[][]{{1,3},{0,2}};
//        // false
//        // [3, 1, 0, 0]
//        System.out.println(f(nums, queries));
    }

    /**
     * 我的题解（nums.length很大时超时了）
     * @param nums
     * @param queries
     * @return
     */
    public static boolean f(int[] nums, int[][] queries) {
        int n = nums.length;
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                    nums[j]--;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 官方题解
     * @param nums
     * @param queries
     * @return
     */
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int[] deltaArray = new int[nums.length + 1];
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            deltaArray[left] += 1;
            deltaArray[right + 1] -= 1;
        }
        int[] operationCounts = new int[deltaArray.length];
        int currentOperations = 0;
        for (int i = 0; i < deltaArray.length; i++) {
            currentOperations += deltaArray[i];
            operationCounts[i] = currentOperations;
        }
        for (int i = 0; i < nums.length; i++) {
            if (operationCounts[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
