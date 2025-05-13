/**
 * @Author: sangui
 * @CreateTime: 2025-05-13
 * @Description: lengthAfterTransformations
 * @Version: 1.0
 */
public class Q_3335 {
    public static void main(String[] args) {
//        String s = "abcyy";
//        int t = 2;
//        // 7
//        System.out.println(f(s, t));

//        String s = "azbk";
//        int t = 1;
//        // 5 babcl
//        System.out.println(f(s, t));
        String s = "jqktcurgdvlibczdsvnsg";
        int t = 7517;
        // 5 babcl
        System.out.println(f(s, t));
    }
    // array[1]代表a，array[26]代表z
    static int array[];
    static final int MOD = 1_000_000_007;
    public static int f(String s, int t) {
        array = new int[27];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            array[ch - 'a' + 1]++;
        }
        //System.out.println(Arrays.toString(array));
        int ans = 0;
        for (int i = 1; i <= 26; i++) {
            ans += (mainF(t,i) % MOD);
            //System.out.print(mainF(t,i) + ",");
        }
        //System.out.println();
        return ans % MOD;
    }
    // 在第t次时出现字母的次数
    public static int mainF(int t,int b){
        if(t == 0){
            return array[b];
        }else if (b == 2){
            //System.out.println("出现b");
            return mainF(t - 1, 1) + mainF(t - 1, 26);
        }else if (b == 1){
            //System.out.println("出现a");
            return mainF(t - 1, 26);
        }else {
            return mainF(t - 1, b - 1);
        }
    }
}
