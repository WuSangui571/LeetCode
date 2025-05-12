import java.util.*;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-12
 * @Description: findEvenNumbers
 * @Version: 1.0
 */
public class Q_2094 {
    static List<Integer> list = new ArrayList<>();
    static int one = 0;
    static int two = 0;
    static int three = 0;
    public static void main(String[] args) {
//        int digits[] = new int[]{1,2,3};
//        // [132,312]
//        System.out.println(Arrays.toString(f(digits)));

//        int digits[] = new int[]{2,1,3,0};
//        // [102,120,130,132,210,230,302,310,312,320]
//        System.out.println(Arrays.toString(f(digits)));


        int digits[] = new int[]{2,2,8,8,2};
        // [222,228,282,288,822,828,882]
        System.out.println(Arrays.toString(f(digits)));


//        int digits[] = new int[]{3,7,5};
//        // []
//        System.out.println(Arrays.toString(f(digits)));

//        int digits[] = new int[]{0,7,5};
//        // [750,570]
//        System.out.println(Arrays.toString(f(digits)));

    }
    public static int[] f(int[] digits) {
        int n = digits.length;
        int evenCount = getEvenCount(digits);
        if (evenCount == 0){
            return new int[0];
        }
        for (int i = 0; i < n; i++) {
            if (digits[i] % 2 == 0){
                mainF(digits, i);
            }
        }
        int[] res = getArrayIncrease(new ArrayList<>(new HashSet<>(list)));
        list.clear();
        return res;
    }
    public static void mainF(int[] a,int end){

        for (int i = 0; i < a.length; i++) {
            if (i == end || a[i] == 0 ){
//            if (i == end || a[i] == 0 || a[i] == a[end]){
                continue;
            }
            // a[i] 是第一个数字
            one = a[i];
            two = one * 10;
            for (int j = 0; j < a.length; j++) {
                if (j == end || i == j ){
//                if (j == end || i == j || a[j]== a[end] || a[j] == a[i]){
                    continue;
                }
                // a[j] 是第2个数字
                two = two + a[j];
                three = two * 10;
                // a[end] 是第3个数字
                three = three + a[end];
                list.add(three);
                three = three - a[end];
                two = two - a[j];

            }
        }

    }

    public static int getEvenCount(int[] digits) {
        int count = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 2 == 0){
                count++;
            }
        }
        return count;
    }

    public static int[] getArrayIncrease(List<Integer> list) {
        // list转数组
        int[] a = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            a[i] = list.get(i);
        }

        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
