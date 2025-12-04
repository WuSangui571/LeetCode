/**
 * @Author: sangui
 * @CreateTime: 2025-12-04
 * @Description:
 * @Version: 1.0
 */
public class Q_2211 {
    public static void main(String[] args) {
        // case1
//        String directions = "RLRSLL";
//        int res = countCollisions(directions);
//        // 5
//        System.out.println(res);

//        // case2
//        String directions = "LLRR";
//        int res = countCollisions(directions);
//        // 0
//        System.out.println(res);


        // case3
//        String directions = "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
//        int res = countCollisions(directions);
//        // 20
//        System.out.println(res);

        // case4
        String directions = "LSSSLLSSSSLRRSLLLSLSLRRLLLLLRSSRSRRSLLLSSS";
        int res = countCollisions(directions);
        // 24
        System.out.println(res);
    }

    public static int countCollisions(String directions) {
        int n = directions.length();
        boolean lastPlace = false;
        int res = 0;
        int continueCount = 0;
        for (int i = 0; i < n; i++) {
            char c = directions.charAt(i);
            if (c == 'R') {
                if (i != n - 1) {
                    char c2 = directions.charAt(i + 1);
                    if (c2 == 'L') {
                        res += 2;
                        if (continueCount != 0){
                            res += continueCount;
                            //System.out.println("res += continueCount，此时 i = " + i + "，res = " + res + "，continueCount = " + continueCount);
                            continueCount = 0;
                        }
                        //System.out.println("res + 2，此时 i = " + i + "，res = " + res);
                        lastPlace = true;
                        i++;
                    } else if (c2 == 'S') {
                        res++;
                        if (continueCount != 0){
                            res += continueCount;
                            //System.out.println("res += continueCount，此时 i = " + i + "，res = " + res + "，continueCount = " + continueCount);
                            continueCount = 0;
                        }
                        //System.out.println("res + 1，此时 i = " + i + "，res = " + res);
                        lastPlace = true;
                        i++;
                    } else if (c2 == 'R') {
                        continueCount++;
                        //System.out.println("continueCount++，此时 continueCount = " + continueCount+ "，i = " + i);
                        lastPlace = false;
                    }
                }
            } else if (c == 'L') {
                if (i != 0) {
                    if (lastPlace) {
                        res++;
                        //System.out.println("res + 1，此时 i = " + i + "，res = " + res);
                    }
                }
            }else if (c == 'S') {
                lastPlace = true;
            }
        }
        return res;
    }
}
