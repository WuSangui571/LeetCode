/**
 * @Author: sangui
 * @CreateTime: 2025-05-02
 * @Description: merge-two-sorted-lists
 * @Version: 1.0
 */
public class Q_21 {
    public static void main(String[] args) {

    }
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }

            ListNode head = new ListNode(0);
            ListNode cur = head;
            ListNode cur1 = list1;
            ListNode cur2 = list2;

            while(cur1 != null && cur2 != null) {
                if(cur1.val < cur2.val) {
                    cur.next = cur1;
                    cur = cur.next;
                    cur1 = cur1.next;
                }else {
                    cur.next = cur2;
                    cur = cur.next;
                    cur2 = cur2.next;
                }
            }
            if (cur1 == null) {
                cur.next = cur2;
            }
            if (cur2 == null) {
                cur.next = cur1;
            }
            return head.next;
        }
    }
    public class ListNode {
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
