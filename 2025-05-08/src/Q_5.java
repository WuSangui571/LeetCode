/**
 * @Author: sangui
 * @CreateTime: 2025-05-08
 * @Description: longestPalindrome
 * @Version: 1.0
 */
public class Q_5 {
    public static void main(String[] args) {
//        String s = "babad";
//        // bab
//        System.out.println(f(s));

//        String s = "cbbd";
//        // bb
//        System.out.println(f(s));
        String s = "abcda";
        // a
        System.out.println(f(s));

    }
    public static String f(String s) {
        int l = s.length();
        if (l == 1){
            return s;
        }
        int left;
        int right;
        for (int i = l; i > 1; i--) {
            left = 0;
            right = left + i - 1;
            if (isPalindromic(s.substring(left, right + 1))) {
                return s.substring(left, right + 1);
            }
            while(left + i <= l ){
                left++;
                right = left + i - 1;
                if (right >= l){
                    break;
                }
                if (isPalindromic(s.substring(left, right + 1))) {
                    return s.substring(left, right + 1);
                }
            }
        }
        return String.valueOf(s.charAt(0));
    }
    public static boolean isPalindromic (String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
