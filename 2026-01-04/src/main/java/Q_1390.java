/**
 * @Author: sangui
 * @CreateTime: 2026-01-04
 * @Description:
 * @Version: 1.0
 */
public class Q_1390 {
    public static void main(String[] args) {
//        System.out.println(21 / 2);
        Q_1390 q1390 = new Q_1390();
//        int[] nums = {21, 4, 7};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
//        int[] nums = {7286, 18704, 70773, 8224, 91675};

        int[] nums2 = new int[100];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = i + 1;
        }
        int res = q1390.sumFourDivisors(nums2);
        // 10932
        System.out.println(res);
    }

    public int sumFourDivisors(int[] nums) {
        int count = 0;
        int len = nums.length;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < len; i++) {
            int item = nums[i];
            if (item < 6) {
                continue;
            }
            int flag = 0;
            int tempCount = 0;
            for (int j = 2; j <= Math.sqrt(item); j++) {
                if (j * j == item && flag==1) {
                    tempCount = 0;
                    flag = 2;
                }
                if (item % j == 0 && (j != (item / j))) {
                    //                    System.out.println("正在审查：" + item + "/" + j);
                    if (flag == 0) {

                        flag = 1;
                        tempCount = (1 + item + j + (item / j));
                        temp1 = j;
                        temp2 = (item / j);
                        //                        System.out.println("疑似四因子，正在检查：" + item + "，发现因子：" + j + " 和 " + (item / j));
                        if (j == 2 && (item != 6 && item != 8) && (item / j) % 2 == 0) {
                            tempCount = 0;
                            break;
                        }
                    } else if (flag == 1) {

                        flag = 2;
                        tempCount = 0;
                    }
                }
            }
            if (flag != 0 && tempCount != 0) {
                System.out.println("已通过四因子：" + item + "，它的四个因子和为：1 + " + temp1 + " + " + temp2 + " + " + item + " = " + tempCount);
                count += tempCount;
            }

        }
        return count;
    }
}
