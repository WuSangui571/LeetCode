/**
 * @Author: sangui
 * @CreateTime: 2025-10-22
 * @Description:
 * @Version: 1.0
 */
public class Q_10 {
    public static void main(String[] args) {
        // Case1
//        String s = "aa";
//        String p = "a";
//        // 预期输出：false
//        System.out.println(isMatch(s, p));

        // Case2
//        String s = "aa";
//        String p = "a*";
//        // 预期输出：true
//        System.out.println(isMatch(s, p));

        // Case3
//        String s = "ab";
//        String p = ".*";
//        // 预期输出：true
//        System.out.println(isMatch(s, p));

        // Case4
        String s = "abcdefg";
        String p = "a*d*g";
        // 预期输出：true
        System.out.println(isMatch(s, p));

//        System.out.println(isMatchNormal("abcd","abcd"));
//        System.out.println(isMatchNormal("abcd","ab_d"));
//        System.out.println(isMatchNormal("abcd","ac_d"));
//        System.out.println(isMatchNormal("abc","abcd"));


        // 3
//        System.out.println("abc*d".indexOf('*'));

        // -1
//        System.out.println("abcd".indexOf('*'));
//        System.out.println("abcd".indexOf('*'));
        // *d
//        System.out.println("abc*d".substring(3));
        // abc
//        System.out.println("abc*d".substring(0,3));

    }

    public static boolean isMatch(String s, String p) {
        System.out.println("比较开始，比较字符串：\"" + s + "\" ，通配符： \"" + p + "\"");
        String p1 = "";
        String p2 = p;
        String s1 = "";
        String s2 = s;
        if (p2.indexOf('*') == -1) {
            return s.equals(p);
        }
        while (p2.indexOf('*') != -1) {
            int firstStarIndex = p2.indexOf('*');
            p1 = p2.substring(0, firstStarIndex);
            p2 = p2.substring(firstStarIndex + 1);
            System.out.println("通配符拆分了，拆分成了:\"" + p1 + "\" 和 \"" + p2 + "\"");
            s1 = s2.substring(0, firstStarIndex);
            s2 = s2.substring(firstStarIndex);
            System.out.println("字符串拆分了，拆分成了:\"" + s1 + "\" 和 \"" + s2 + "\"");
            while (!isMatchNormal(s1, p1)) {
                s1 = s1 + s2.charAt(0);
                s2 = s2.substring(1);
                System.out.println("之前的拆分失败了，继续拆分，拆分成了:\"" + s1 + "\" 和 \"" + s2 + "\"");
                return false;
            }
        }
        return true;
    }

    /*
     * p 里面没有 * 号的比较方法
     */
    public static boolean isMatchNormal(String s, String p) {
        int len_s = s.length();
        int len_p = p.length();
        if (len_s != len_p) {
            System.out.println("无 * 号的两个字符比较：\"" + s + "\" == \"" + p + "\" ? -> false");
            return false;
        }
        for (int i = 0; i < len_s; i++) {
            if (p.charAt(i) == '_') {
                continue;
            }
            if (s.charAt(i) != p.charAt(i)) {
                System.out.println("无 * 号的两个字符比较：\"" + s + "\" == \"" + p + "\" ? -> false");
                return false;
            }
        }
        System.out.println("无 * 号的两个字符比较：\"" + s + "\" == \"" + p + "\" ? -> true");
        return true;
    }
}
