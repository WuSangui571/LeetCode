import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2026-01-22
 * @Description:
 * @Version: 1.0
 */
public class Q3507 {
    public static void main(String[] args) {
        // 2
        int[] nums = {5, 2, 3, 1};
        Q3507 q3507 = new Q3507();
        int res = q3507.minimumPairRemoval(nums);
        System.out.println(res);
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            list.add(nums[i]);
        }
        int count = 0;
        int minSum;
        int currentIndex;
        int minIndex;
        int currentSize;
        while (!isSorted(list)) {
            currentIndex = 0;
            minIndex = 0;
            minSum = Integer.MAX_VALUE;
            currentSize = list.size();
            while ((currentIndex + 1) < currentSize) {
                int tempSum = list.get(currentIndex) + list.get(currentIndex + 1);
                if (tempSum < minSum) {
                    minSum = tempSum;
                    minIndex = currentIndex;

                }
                currentIndex++;
            }
            Integer remove = list.remove(minIndex + 1);
            list.set(minIndex, list.get(minIndex) + remove);
            count++;
        }

        return count;
    }

    public boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
