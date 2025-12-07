import javax.print.DocFlavor;

/**
 * @Author: sangui
 * @CreateTime: 2025-12-07
 * @Description:
 * @Version: 1.0
 */
public class Q_3432 {
    public static void main(String[] args) {
        // case1
//        int[] nums = {10,10,3,7,6};
//        Q_3432 q = new Q_3432();
//        int res = q.countPartitions(nums);
//        // 4
//        System.out.println(res);

        // case2
//        int[] nums = {1,2,2};
//        Q_3432 q = new Q_3432();
//        int res = q.countPartitions(nums);
//        // 0
//        System.out.println(res);

        // case3
        int[] nums = {2,4,6,8};
        Q_3432 q = new Q_3432();
        int res = q.countPartitions(nums);
        // 3
        System.out.println(res);
    }
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return 0;
        }else {
            return nums.length - 1;
        }
    }
}
