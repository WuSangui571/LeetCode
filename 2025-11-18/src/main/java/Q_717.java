/**
 * @Author: sangui
 * @CreateTime: 2025-11-18
 * @Description:
 * @Version: 1.0
 */
public class Q_717 {
    public static void main(String[] args) {
        // case1
//        int[] bits = {1, 0, 0};
//        boolean res = isOneBitCharacter(bits);
//        // true
//        System.out.println(res);

        // case2
        int[] bits = {1,1,1,0};
        boolean res = isOneBitCharacter(bits);
        // false
        System.out.println(res);
    }
    public static boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            int item = bits[i];
            if (item == 1){
                i++;
                continue;
            }
            if (item == 0 && i == bits.length - 1){
                return true;
            }
        }
        return false;
    }
}
