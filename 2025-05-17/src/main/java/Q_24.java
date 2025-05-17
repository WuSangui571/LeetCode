/**
 * @Author: sangui
 * @CreateTime: 2025-05-17
 * @Description: swapPairs
 * @Version: 1.0
 */
public class Q_24 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        ListNode head = new ListNode(1);
        System.out.print("old : ");
        print(head);
        // [2,1,4,3]
        System.out.print("new : ");
        print(exchange(head));

    }
    public static ListNode f(ListNode head){

        ListNode curNode = head;

        while (curNode != null) {
            System.out.print("2.beforeChange : ");
            print(curNode);
            curNode.next = exchange(curNode.next);
            System.out.print("3.afterChange : ");
            print(curNode);
            try {
                curNode = curNode.next;
            }catch (Exception e){
            } finally {
                return head;
            }
        }
        return head;
    }
//    public static ListNode exchange(ListNode head) {
//        if (head == null || head.next == null){
//            return head;
//        }
//        ListNode temp = new ListNode(head.next.val);
//        head.next = head.next.next;
//        temp.next = head;
//        return temp;
//    }
    public static ListNode exchange(ListNode head) {
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            int temp = curNode.val;
            curNode.val = curNode.next.val;
            curNode.next.val = temp;
            curNode = curNode.next.next;
        }
        return head;
    }


    public static void print(ListNode l) {
        while (l.next != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.print(l.val);
        System.out.println();
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
