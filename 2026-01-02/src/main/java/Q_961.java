import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Author: sangui
 * @CreateTime: 2026-01-02
 * @Description:
 * @Version: 1.0
 */
public class Q_961 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        Q_961 obj = new Q_961();
        int res = obj.repeatedNTimes(nums);
        // 3
        System.out.println(res);
    }
    public int repeatedNTimes2(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < nums.length / 2 + 2; i++) {
            Integer item = nums[i];
            if (mySet.contains(item)){
                return item;
            }else {
                mySet.add(item);
            }
        }
        return 0;
    }
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Random random = new Random();
        while (true){
            int i = random.nextInt(n);
            int j = random.nextInt(n);
            if ((nums[i] == nums[j]) && (i != j)){
                return nums[i];
            }
        }
    }
}
