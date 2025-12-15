import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-12-12
 * @Description:
 * @Version: 1.0
 */
public class Q_3433 {
    public static void main(String[] args) {
        int numberOfUsers = 2;
        List<List<String>> events = new ArrayList<>();

        List<String> temp1 = new ArrayList<>();
        temp1.add("MESSAGE");
        temp1.add("10");
        temp1.add("id1 id0");
        events.add(temp1);

        List<String> temp2 = new ArrayList<>();
        temp2.add("OFFLINE");
        temp2.add("11");
        temp2.add("0");
        events.add(temp2);

        List<String> temp3 = new ArrayList<>();
        temp3.add("MESSAGE");
        temp3.add("71");
        temp3.add("HERE");
        events.add(temp3);

        Q_3433 q = new Q_3433();
        int[] res = q.countMentions(numberOfUsers, events);
        // [2,2]
        System.out.println(Arrays.toString(res));
    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        return null;
    }
}
