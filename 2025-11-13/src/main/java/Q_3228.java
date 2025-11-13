import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-11-13
 * @Description:
 * @Version: 1.0
 */
public class Q_3228 {

    public static void main(String[] args) {
        String s = "1001101";
        int res = maxOperations2(s);
        // 预期 11
        System.out.println(res);

//        String s = "00111";
//        int res = maxOperations2(s);
//        // 预期 0
//        System.out.println(res);

//        String s = "11";
//        int res = maxOperations(s);
//        // 预期 0
//        System.out.println(res);
        //System.out.println("1234".substring(2));

    }


    public static int maxOperations(String s) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        if (!s.contains("1")) {
            return 0;
        }
        s = s.substring(s.indexOf("1"));
        if (s.length() <= 1) {
            return 0;
        }
        int index = 0;
        while (s.contains("0") && index <= s.length() - 2) {
//            for (int i = s.length() - 1; i >= 1; i--) {
//                char ch = s.charAt(i);
//                if (ch == '0' && s.charAt(i - 1) == '1') {
//                    for (int j = i - 1; j >= 0; j--) {
//                        char ch2 = s.charAt(j);
//                        if (ch2 == '1') {
//                            count++;
//                        }
//                    }
//                }
//
            if (s.charAt(index) == '1' && s.charAt(index + 1) == '0') {
                count = (countOne(s.substring(0, index)) + 1);
                list.add(count);
                System.out.println("list add:" + count);
                if (index + 2 >= s.length()) {
                    return countList(list);
                }
                System.out.print("切割s:" + s);
                s = s.substring(index + 2);

                //s = s.substring(s.indexOf("1"));
                index = 0;
                System.out.println("->" + s);
            } else {
                index++;
            }

        }
        return countList(list);
    }

    public static int countOne(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    static int countList(List<Integer> list) {
        int value = 1;
        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res += (list.get(i) * value);
            value++;
        }
        return res;
    }

    public static int maxOperations2(String s) {
        int res = 0;
        int value = 1;
        int count = 0;
        int lastIndexOfOne = s.lastIndexOf("0");
        for (int i = lastIndexOfOne - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                if (count != 0) {
                    res += (count * value);
                    value++;
                    count = 0;
                }
            }
        }
        res += (count * value);
        return res;
    }
}
