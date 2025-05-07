import java.math.BigInteger;

/**
 * @Author: sangui
 * @CreateTime: 2025-05-07
 * @Description: addTwoNumbers
 * @Version: 1.0
 */
public class Q_2 {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(9);
//        l1.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next.next = new ListNode(9);
//
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);

        ListNode l1 = new ListNode(5);



        ListNode l2 = new ListNode(5);



//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        //ListNode ans = f(l1, l2);
        ListNode ans = gpt(l1, l2);

        System.out.println("最终答案：");
        print(ans);

    }
    static ListNode temp = new ListNode();
    static ListNode cur = new ListNode();
    public static ListNode gpt(ListNode l1, ListNode l2) {
        // 虚拟头节点，方便构造结果链表
        ListNode dummy = new ListNode(0);

        // p、q分别遍历l1、l2，curr负责构造新链表
        ListNode p = l1, q = l2, curr = dummy;
        // 记录进位
        int carry = 0;

        while (p != null || q != null) {
            // p当前位
            int x = (p != null) ? p.val : 0;
            // q当前位
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;

            // 新进位
            carry = sum / 10;
            // 当前位值
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
    public static ListNode f(ListNode l1, ListNode l2) {
//        print(l1);
//        re(l1);
//        ListNode r_l1 = temp;
//        print(r_l1);
//        re(l2);
//        ListNode r_l2 = temp;
//        print(r_l2);
        boolean flag = false;
        ListNode head = new ListNode();
        ListNode current = head;
        ListNode cur_l1 = l1;
        ListNode cur_l2 = l2;
        while (cur_l1 != null && cur_l2 != null) {
            System.out.println("------------");
            int num;
            if (flag){
                System.out.println("之前有进位");
                num = cur_l1.val + cur_l2.val + 1;
                System.out.println(cur_l1.val + " + " + cur_l2.val + "+ 1,");
            }else {
                System.out.println("之前没有进位");
                num = cur_l1.val + cur_l2.val;
                System.out.println(cur_l1.val + " + " + cur_l2.val + ",");
            }
            if (num >= 10) {
                current.val = num % 10;
                System.out.println("相加后有进位：" +  num);
                flag = true;
            }else {
                current.val = num;
                System.out.println("相加后没有进位，值为：" + num);
                flag = false;
            }
            if (cur_l1.next != null && cur_l2.next != null){
                current.next = new ListNode();
                current = current.next;
            }
                cur_l1 = cur_l1.next;
                cur_l2 = cur_l2.next;
            System.out.println("------------");
        }
        if (cur_l1 == null && cur_l2 == null){
            if (flag) {
                System.out.println("最后存在进位");
                current.next = new ListNode();
                current.next.val = 1;
            }else {
                System.out.println("最后bu存在进位");
            }
            return head;
        }
        System.out.println("暂时的表：");
        //print(head);
        System.out.println("current.val:" + current.val);
        System.out.println("从这里开始两个链表中有一个是空的");
        if (cur_l1 == null) {
            System.out.println("链表1为空，2不空");
            current.next = new ListNode();
            current = current.next;
            while (cur_l2 != null) {
                if (flag) {
                    int num = cur_l2.val + 1;
                    if (num >= 10) {
                        current.val = num % 10;
                    }else {
                        current.val = num;
                        flag = false;
                    }

                }else {
                    current.val = cur_l2.val;

                }
                cur_l2 = cur_l2.next;
                if (cur_l2 != null){
                    current.next = new ListNode();
                    current = current.next;
                }
            }
            System.out.println("结束");
            if (flag) {
                System.out.println("最后存在进位");
                current.next = new ListNode();
                current.next.val = 1;
            }else {
                System.out.println("最后bu存在进位");
            }
            return head;
        }

        if (cur_l2 == null) {
            System.out.println("链表2为空，1不空");
            current.next = new ListNode();
            current = current.next;
            while (cur_l1 != null) {
                System.out.println("----------------");
                if (flag) {
                    System.out.println("上一步存在进位");
                    int num = cur_l1.val + 1;
                    if (num >= 10) {
                        current.val = num % 10;
                        System.out.println("值为：" + current.val);
                    }else {
                        current.val = num;
                        System.out.println("值为：" + current.val);
                        flag = false;
                    }


                }else {
                    System.out.println("上一步不存在进位");
                    current.val = cur_l1.val;
                    System.out.println("值为：" + current.val);

                }

                cur_l1 = cur_l1.next;
                if (cur_l1 != null){
                    current.next = new ListNode();
                    current = current.next;
                }
                System.out.println("----------------");
            }
            System.out.println("结束");
            if (flag) {
                System.out.println("最后存在进位");
                current.next = new ListNode();
                current.next.val = 1;
            }else {
                System.out.println("最后bu存在进位");
            }
            return head;
        }
        return head;
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
