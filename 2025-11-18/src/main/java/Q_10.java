/**
 * @Author: sangui
 * @CreateTime: 2025-11-18
 * @Description:
 * @Version: 1.0
 */
public class Q_10 {
    public static void main(String[] args) {
        // case1
//        String s = "aa";
//        String p = "a";
//        boolean res = isMatch(s, p);
//        // false
//        System.out.println(res);

        // case2
//        String s = "aa";
//        String p = "a*";
//        boolean res = isMatch(s, p);
//        // true
//        System.out.println(res);

        // case3
//        String s = "ab";
//        String p = ".*";
//        boolean res = isMatch(s, p);
//        // true
//        System.out.println(res);

        // case4
        String s = "aab";
        String p = "c*a*b";
        boolean res = isMatch(s, p);
        // true
        System.out.println(res);

//        System.out.println("abcde".substring(1, 1 + 2));
    }

//    public static boolean isMatch(String s, String p) {
//        int n = s.length();
//        int pIndex = 0;
//        int sIndex;
//        boolean flag = true;
//        for (sIndex = 0; sIndex <= n - 1; sIndex++) {
//            int tempPIndex = pIndex;
//            System.out.println("tempPIndex = " + tempPIndex);
//            for (int j = 1; j <= n - 1 - sIndex; j++) {
//                if (f(s.substring(sIndex, sIndex + j), p.charAt(pIndex))) {
//                    pIndex++;
//                    flag = true;
//                } else {
//                    flag = false;
//                }
//            }
//            System.out.println("pIndex = " + pIndex);
//            if (pIndex == tempPIndex) {
//                if (pIndex < p.length()) {
//                    pIndex++;
//                }else {
//                    return false;
//                }
//                sIndex--;
//            }
//        }
//        System.out.println("pIndex = " + pIndex);
//        System.out.println("sIndex = " + sIndex);
//        if (pIndex >= p.length()) {
//            return false;
//        }
//        return flag;
//    }

    public static boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int n = s.length();

//        while (sIndex < s.length() && pIndex < p.length()) {
//            for (int i = sIndex; i < n; i++) {
//                for (int j = 1; j <= n - 1 - sIndex; j++) {
//                    if (f(s.substring(sIndex, sIndex + j), p.charAt(pIndex))) {
//
//                    }
//                }
//            }
//        }
        return false;
    }

    /**
     * 单字符规律匹配
     *
     * @param str 匹配的字符串
     * @param ch  单字符规律
     * @return 是否匹配
     */
    public static boolean f(String str, char ch) {
        System.out.println("比较：" + str + " 和 [" + ch + "]");
        if (str.isEmpty() && ch == '*') {
            return true;
        }
        if (str.length() == 1 && (str.charAt(0) == ch || ch == '.')) {
            return true;
        }
        if ('*' == ch) {
            return true;
        }
        return false;
    }
}
