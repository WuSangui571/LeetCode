/**
 * @Author: sangui
 * @CreateTime: 2025-05-19
 * @Description: triangleType
 * @Version: 1.0
 */
public class Q_3024 {
    public static void main(String[] args) {
//        int nums[] = new int[]{3,3,3};
//        // equilateral
//        System.out.println(f(nums));

        int nums[] = new int[]{3,4,5};
        // scalene
        System.out.println(f(nums));
    }
    public static String f(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if (a + b <= c || b + c <= a || c + a <= b){
            return "none";
        }
        if (b == c && a == c){
            return "equilateral ";
        }
        if (a == b || a == c || b == c){
            return "isosceles ";
        }
        return "scalene ";
    }
}
