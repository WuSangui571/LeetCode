import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: sangui
 * @CreateTime: 2025-12-09
 * @Description: \
 * @Version: 1.0
 */
public class Q_3583 {
    public static void main(String[] args) {
        // case1
        int[] nums = {6,3,6};
        Q_3583 obj = new Q_3583();
        int res = obj.specialTriplets(nums);
        // 1
        System.out.println(res);

        // case2
//        int[] nums = {0,1,0,0};
//        Q_3583 obj = new Q_3583();
//        int res = obj.specialTriplets(nums);
//        // 1
//        System.out.println(res);

        // case3
//        int[] nums = {8,4,2,8,4};
//        Q_3583 obj = new Q_3583();
//        int res = obj.specialTriplets(nums);
//        // 2
//        System.out.println(res);
    }
    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(i,nums[i]);
        }
        return 0;
    }
}
