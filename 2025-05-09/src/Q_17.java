import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-09
 * @Description: letterCombinations
 * @Version: 1.0
 */
public class Q_17 {
    public static void main(String[] args) {
        String a = "23";
        System.out.println(f(a));
    }
    public static List<String> f(String a) {
        if (a.isEmpty()){
            return new ArrayList<>();
        }
        int n = a.length();
        for (int i = 0; i < n; i++) {
            char c = a.charAt(i);
        }
        return null;
    }
    public static String appendString(String a,char c){
        StringBuilder sb = new StringBuilder(a);
        return String.valueOf(sb.append(c));
    }
}
