import java.util.*;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-13
 * @Description:
 * @Version: 1.0
 */
public class Q_15 {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0,0,0,0};
        int[] nums = {-100,-70,-60,110,120,130,160};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
//        Map<List<Integer>,Integer> map = new HashMap<>();
//
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(1);
//
//        map.put(list1,1);
//        map.put(list2,2);
//        System.out.println(map);
//        System.out.println(Arrays.toString(f(1,0,2)));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println("整理之后的数组：" + Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>();
        for (int left = 0; left <= nums.length - 3; left++) {
            int mid = left + 1;
            int right = nums.length - 1;
            int sum;
            while (mid < right) {
                sum = (nums[left] + nums[mid] + nums[right]);
                System.out.println("leftIndex=" + left+",midIndex="+mid+",rightIndex=" +right);
                System.out.println("leftValue=" + nums[left]+",midValue="+nums[mid]+",rightValue=" +nums[right]+",sum="+sum);
                if (sum == 0) {
                    res.add(Arrays.asList(nums[left],nums[mid],nums[right]));
                    while (mid < right && nums[mid] == nums[mid+1]){
                        mid++;
                    }
                    while (mid < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    mid++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
            while ((left <= nums.length - 3) && (nums[left] == nums[left+1])){
                left++;
            }
        }
        return res;
    }


}
