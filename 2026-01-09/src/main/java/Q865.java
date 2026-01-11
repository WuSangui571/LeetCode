import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: sangui
 * @CreateTime: 2026-01-09
 * @Description:
 * @Version: 1.0
 */
public class Q865 {
    public static void main(String[] args) {
//        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
//        Integer[] arr = {1};
        Integer[] arr = {0, 1, 3, null, 2};
        TreeNode treeNode = transfer(arr);
        printTree(treeNode);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return null;
    }

    public static TreeNode transfer(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        int n = arr.length;
        if (n == 1) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
//        System.out.println("「" + root.val + "」入队列");
        for (int i = 0; i < n; i++) {
            TreeNode tempNode = queue.poll();
            if ((2 * i + 1) < n && tempNode != null) {
                if (arr[2 * i + 1] != null) {
                    tempNode.left = new TreeNode(arr[2 * i + 1]);
                    queue.offer(tempNode.left);
//                    System.out.println("「" + tempNode.left.val + "」入队列");
                }

            }
            if ((2 * i + 2) < n) {
                if (arr[2 * i + 2] != null) {
                    tempNode.right = new TreeNode(arr[2 * i + 2]);
                    queue.offer(tempNode.right);
//                    System.out.println("「" + tempNode.right.val + "」入队列");
                }
            }
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    public static void printTree(TreeNode node, int level) {
        if (node == null) return;
        printTree(node.left, level + 1);
        System.out.println(node.val);
        printTree(node.right, level + 1);
    }
}

