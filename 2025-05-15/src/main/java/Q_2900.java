import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-15
 * @Description: getLongestSubsequence
 * @Version: 1.0
 */
public class Q_2900 {
    public static void main(String[] args) {
//        String[] words = new String[] {"e","a","b"};
//        int[] groups = new int[] {0,0,1};
//          // ["e","b"]
//        System.out.println(getLongestSubsequence(words,groups));

        String[] words = new String[] {"a","b","c","d"};
        int[] groups = new int[] {1,0,1,1};
        // ["a","b","c"]
        System.out.println(getLongestSubsequence(words,groups));
    }
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        //int firstMax = 0;
        int lastIndex = 0;
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != groups[lastIndex]) {
                //firstMax++;
                list.add(words[i]);
                lastIndex = i;
            }
        }

        return list;
    }

}
