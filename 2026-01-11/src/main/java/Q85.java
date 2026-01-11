import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: sangui
 * @CreateTime: 2026-01-11
 * @Description:
 * @Version: 1.0
 */
public class Q85 {
    public static void main(String[] args) {
        // 6
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        // 0
//        char[][] matrix = {{'0'}};

        // 1
//        char[][] matrix = {{'1'}};

        // 1
        char[][] matrix = {{'0', '1'}};

        // 2
//        char[][] matrix = {{'1', '1'}};

        Q85 obj = new Q85();
        int res = obj.maximalRectangle(matrix);
        // 6
        System.out.println(res);
    }

    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
//            System.out.println("第「" + i + "」行，height = " + Arrays.toString(height));
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j <= height.length; j++) {
                int cur = (j == height.length ? 0 : height[j]);
                if (stack.isEmpty() || cur > height[stack.peek()]) {
                    stack.push(j);
//                    System.out.println("height 数组里值为的 " + cur + " 的坐标:「" + j + "」入栈了！此时stack=" + stack);
                } else {
                    while (!stack.isEmpty() && height[stack.peek()] >= cur) {
                        int popIndex = stack.pop();
                        int left = -1;
                        if (!stack.isEmpty()) {
                            left = stack.peek();
                        }
                        int width = j - left - 1;
                        int area = width * height[popIndex];
                        if (area > maxArea) {
                            maxArea = area;
                        }
//                        System.out.println("计算面积=" + width + "(宽)*" + height[popIndex] + "(长)=" + area);
//                        System.out.println("height[]中的 " + height[popIndex] + " 的坐标:「" + popIndex + "」出栈了！此时stack=" + stack);
                    }
                    stack.push(j);
//                    System.out.println("height[]中的 " + cur + " 的坐标:「" + j + "」入栈了！此时stack=" + stack);
                }
            }
        }
        return maxArea;
    }
}
