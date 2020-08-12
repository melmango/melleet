package cn.melman.melleet;

public class Q092 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode cursor = head;//游标
        ListNode ahead = null;//转换起始点
        ListNode pre = null;//往后甩的
        ListNode tail = null;//子链尾巴
        n = n - m + 1;
        ListNode temp;
        for (; ; ) {
            if (m == 0) {
                temp = cursor;
                n--;
                if (n == 1) {
                    tail.next = cursor.next;
                }
                cursor = cursor.next;
                temp.next = pre;
                pre = temp;
                if (n == 1) {
                    if (ahead != null) {
                        ahead.next = pre;
                    } else {
                        head = pre;
                    }
                    break;
                }
            } else {
                if (m == 2) {
                    ahead = cursor;
                } else if (m == 1) {
                    pre = cursor;
                    tail = cursor;
                }
                cursor = cursor.next;
                m--;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode listNode = new Q092().reverseBetween(node, 1, 5);
        while (true) {
            if (listNode == null) {
                break;
            }
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


}
