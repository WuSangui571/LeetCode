import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: sangui
 * @CreateTime: 2025-10-22
 * @Description: 17. 电话号码的字母组合
 * @Version: 1.0
 */
public class Q_17 {
    static List<String> res = new ArrayList<>();
    static Map<Integer,String> map = new HashMap<>();
    public static void main(String[] args) {
//        String digits = "23";
//        // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        System.out.println(letterCombinations(digits));


        String digits = "2398";
        List<String> res = letterCombinations(digits);
        // ["a","b","c"]
        List<String> res2 = res;
        res = new ArrayList<>();
        System.out.println(res2);
    }
    // digits = "2345"
    public static List<String> letterCombinations(String digits) {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        f(digits,new StringBuffer(),0);
        List<String> res2 = res;
        res = new ArrayList<>();
        return res2;
    }
    // 递归函数
    public static void f(String digits,StringBuffer sb,int index){
        if (index == digits.length()){
            res.add(sb.toString());
            return;
        }
        int currentNumber = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String currentString = map.get(currentNumber);
        // 追加对应的字母组合，并递归调用，然后删除末尾的字母
        for (int i = 0; i < currentString.length(); i++) {
            sb.append(currentString.charAt(i));
            f(digits,sb,index+1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }



}
