import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2026-01-20
 * @Description:
 * @Version: 1.0
 */
public class Q3314 {
    public static void main(String[] args) {
        Integer[] arr = {11,13,31};
//        Integer[] arr = {2, 3, 5, 7};
        List<Integer> nums = Arrays.asList(arr);
        Q3314 q3314 = new Q3314();
        int[] res = q3314.minBitwiseArray(nums);
        System.out.println(Arrays.toString(res));
//        System.out.println(q3314.f(11));
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int item = nums.get(i);
            // special case 2
            if (item == 2) {
                ans[i] = -1;
                continue;
            }else {
//                ans[i] = f(item);
//                ans[i] = f2(item);
                ans[i] = item-(1<<(Integer.numberOfTrailingZeros(~item)-1));
            }

        }

        return ans;
    }

    public int f(int a) {
        int temp = a;
        int value = 0;
        while (temp != 0) {
            if (temp % 2 == 0) {
                break;
            } else {
                value++;
                temp /= 2;
            }
        }
//        System.out.println(value);
//        return (a-(int)Math.pow(2,value-1));
        return (a-(1<<(value-1)));
    }

    /**
     * 位运算
     * @param a
     * @return
     */
    public int f2(int a) {
        int overA = ~a;
        int countZero = Integer.numberOfTrailingZeros(overA);
        return (a-(1<<(countZero-1)));
    }
}
