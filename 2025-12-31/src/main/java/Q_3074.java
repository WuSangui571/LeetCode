import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */
public class Q_3074 {
    public static void main(String[] args) {
        Q_3074 obj = new Q_3074();
        int[] apple = {1,3,2};
        int[] capacity = {4,3,1,5,2};
        int res = obj.minimumBoxes(apple, capacity);
        // 2
        System.out.println(res);
    }
    public int minimumBoxes(int[] apple, int[] capacity) {
        int allApple = 0;
        for (int i = 0; i < apple.length; i++) {
            allApple += apple[i];
        }
        Arrays.sort(capacity);
//        System.out.println(Arrays.toString(capacity));
        int res = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            allApple -=capacity[i];
            res++;
            if (allApple <= 0){
                return res;
            }
        }
        return capacity.length;
    }
}
