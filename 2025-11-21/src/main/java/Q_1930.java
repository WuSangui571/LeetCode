/**
 * @Author: sangui
 * @CreateTime: 2025-11-21
 * @Description:
 * @Version: 1.0
 */
public class Q_1930 {
    public static void main(String[] args) {
        // case1
//        String s = "aabca";
//        int res = countPalindromicSubsequence(s);
//        // 3
//        System.out.println(res);

        // case2
//        String s = "adc";
//        int res = countPalindromicSubsequence(s);
//        // 0
//        System.out.println(res);

        // case3
        String s = "bbcbaba";
        int res = countPalindromicSubsequence(s);
        // 4
        System.out.println(res);

//        System.out.println('a' - 96);

//        System.out.println("abcdebg".substring(1+1,5));
//        System.out.println(f("abcad"));
    }

    public static int countPalindromicSubsequence(String s) {
        boolean[] arr = new boolean[27];
        int n = s.length();
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            char ch = s.charAt(i);
            if (!arr[ch - 96]) {
                for (int j = n - 1; j >= i + 2; j--) {
                    if (s.charAt(j) == s.charAt(i)) {
                        arr[ch - 96] = true;
                        count += f(s.substring(i + 1, j));
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static int f(String s) {
        boolean[] arr = new boolean[27];
        int n = s.length();
        int count = 0;
        for (int i = 0; i <= n - 1; i++) {
            char ch = s.charAt(i);
            if (!arr[ch - 96]) {
                arr[ch - 96] = true;
                count++;
            }
        }
        return count;
    }
}
