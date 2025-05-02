/**
 * @Author: sangui
 * @CreateTime: 2025-05-02
 * @Description: plus-one
 * @Version: 1.0
 */
public class Q_66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] == 10) {
                digits[i] = 0;
                if (i == 0){
                    int[] temp = new int[n+1];
                    temp[0] = 1;
                    for (int j = 1; j <= n; j++) {
                        temp[j] = digits[j - 1];
                    }
                    return temp;
                }
            }else {
                break;
            }
        }
        return digits;
    }

}
