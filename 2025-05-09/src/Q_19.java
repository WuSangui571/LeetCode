/**
 * @Author: sangui
 * @CreateTime: 2025-05-09
 * @Description: removeNthFromEnd
 * @Version: 1.0
 */
public class Q_19 {
    static ListNode cur = new ListNode();
    static ListNode temp = new ListNode();
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        int n = 5;
        ListNode head = new ListNode(1);

        int n = 1;
        System.out.println(f(head, n));
    }
    public static ListNode f(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        re(head);
        //System.out.println("反序：");
        //print(temp);
        if (n == 1){
            temp = temp.next;
            head = temp;
            cur =  new ListNode();
            temp = new ListNode();
            re(head);
            return temp;
        }
        ListNode current =  new ListNode();
        current = temp;
        if (n == 2){
            current.next = current.next.next;
            head = temp;
            cur =  new ListNode();
            temp = new ListNode();
            re(head);
            return temp;
        }
        for (int i = 2; i < n; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        head = temp;
        cur =  new ListNode();
        temp = new ListNode();
        re(head);
        //System.out.println("调正的反序：");
        //print(temp);
        return temp;
    }
    public static void re(ListNode l) {
        if (l.next != null){
            re(l.next);
            cur.next = new ListNode();
            cur.next.val = l.val;
            cur = cur.next;
        }else {
            temp.val = l.val;
            cur = temp;
        }
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
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }
}
