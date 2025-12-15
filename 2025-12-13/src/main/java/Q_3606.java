import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: sangui
 * @CreateTime: 2025-12-13
 * @Description:
 * @Version: 1.0
 */
public class Q_3606 {
    public static void main(String[] args) {
        // case1
        String[] code = {"SAVE20","","PHARMA5","SAVE@20"};
        String[] businessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = {true,true,true,true};
        Q_3606 obj = new Q_3606();
        List<String> res = obj.validateCoupons(code, businessLine, isActive);
        // ["PHARMA5","SAVE20"]
        System.out.println(res);

//        System.out.println(checkAscii("SAVE20"));
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> res = new ArrayList<>();
        Set<String> electronicsRes = new HashSet<>();
        Set<String> groceryRes = new HashSet<>();
        Set<String> pharmacyRes = new HashSet<>();
        Set<String> restaurantRes = new HashSet<>();
        int n = code.length;
        for (int i = 0; i < n; i++) {
            if (isActive[i] && checkAscii(code[i])) {
                if ("electronics".equals(businessLine[i])) {
                    electronicsRes.add(code[i]);
                }else if ("grocery".equals(businessLine[i])) {
                    groceryRes.add(code[i]);
                }else if ("pharmacy".equals(businessLine[i])) {
                    pharmacyRes.add(code[i]);
                }else if ("restaurant".equals(businessLine[i])) {
                    restaurantRes.add(code[i]);
                }
            }
        }
        res.addAll(electronicsRes);
        res.addAll(groceryRes);
        res.addAll(pharmacyRes);
        res.addAll(restaurantRes);
        return res;
    }

    public static boolean checkAscii(String str){
        if (str.length() == 0){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!((ch >= 48 && ch <= 57)||(ch >= 65 && ch <= 90)||(ch == 95) || (ch >= 97 && ch <= 122))) {
                return false;
            }
        }
        return true;
    }
}
