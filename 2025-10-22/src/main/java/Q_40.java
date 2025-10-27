import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-10-22
 * @Description: 40. 组合总和Ⅱ
 * @Version: 1.0
 */
public class Q_40 {
    static List<List<Integer>> res = new ArrayList<>(new ArrayList<>());
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        // [[2,2,3],[7]]
        combinationSum(candidates,target);

        System.out.println(res);
        //System.out.println("最终：" + res);
        //System.out.println(res.size());
//        for (int i = 0; i < res.size(); i++) {
//            System.out.print("List " + i + ": ");
//            for (Integer num : res.get(i)) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        f(candidates,new ArrayList<>(),target,-1);
        List<List<Integer>> res2 = res;
        res = new ArrayList<>(new ArrayList<>());
        return res2;
    }
    //
    public static void f(int[] candidates,List<Integer> currentCandidates,int target,int index){
        int currentTarget = 0;
        for (int i = 0; i < currentCandidates.size(); i++) {
            currentTarget += currentCandidates.get(i);
        }
        //System.out.println(currentTarget);
        if (currentTarget == target){
            res.add(new ArrayList<>(currentCandidates));
            //System.out.println("添加：" + currentCandidates);
            return;
        }
        if (currentTarget > target){
            //currentCandidates.removeLast();
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            currentCandidates.add(candidates[i]);
            //System.out.println(currentCandidates);
            f(candidates,currentCandidates,target,i);
            currentCandidates.removeLast();
        }
    }
}
