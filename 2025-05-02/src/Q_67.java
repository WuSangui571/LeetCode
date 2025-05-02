/**
 * @Author: sangui
 * @CreateTime: 2025-05-02
 * @Description: add-binary
 * @Version: 1.0
 */
public class Q_67 {
    public static void main(String[] args) {

        f("1", "1");
    }
    /*
    给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
    示例 1：
    输入:a = "11", b = "1"
    输出："100"

    示例 2：
    输入：a = "1010", b = "1011"
    输出："10101"

    提示：
    1 <= a.length, b.length <= 104
    a 和 b 仅由字符 '0' 或 '1' 组成
    字符串如果不是 "0" ，就不含前导零
     */
    public static String f(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int aCurLen = aLen - 1;
        int bCurLen = bLen - 1;
//        char aNum = a.charAt(aCurLen);
//        char bNum = b.charAt(aCurLen);
//        int d = aNum ^ bNum;
//        System.out.println(d);
        boolean flag = false;
        while (aCurLen >= 0 && bCurLen >= 0) {
            char aNum = a.charAt(aCurLen);
            char bNum = b.charAt(aCurLen);
            int d = aNum ^ bNum;
            if (flag){

            }
            if (d == 0 && aNum == '1') {
                flag = true;
            }else {
                flag = false;
            }

            //System.out.println(d);
            if (aNum == bNum) {}
        }
        StringBuilder sb = new StringBuilder();
        sb.insert(0,"a");

        return sb.toString();
    }
}
