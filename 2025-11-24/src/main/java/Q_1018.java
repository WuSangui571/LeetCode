import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-24
 * @Description:
 * @Version: 1.0
 */
public class Q_1018 {
    public static void main(String[] args) {
        // case1
//        int[] nums = {0, 1, 1};
//        List<Boolean> res = prefixesDivBy5(nums);
//        // [true,false,false]
//        System.out.println(res);

        // case2
//        int[] nums = {1,1,1};
//        List<Boolean> res = prefixesDivBy5(nums);
//        // [false,false,false]
//        System.out.println(res);

        // case3
//        int[] nums = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
//        List<Boolean> res = prefixesDivBy5(nums);
//        // [false,false,false]
//        System.out.println(res);

        // case4
//        int[] nums = {1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0};
//        List<Boolean> res = prefixesDivBy5(nums);
//        // [false,false,false]
//        System.out.println(res);
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int n = nums.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            count = (nums[i] + count * 2);
            //System.out.println(count);
            count=count%5;
            if (count % 5 == 0) {
                res.add(true);
            }else {
                res.add(false);
            }
        }
        return res;
    }

//    public static int f(int[] nums){
//
//    }
}
