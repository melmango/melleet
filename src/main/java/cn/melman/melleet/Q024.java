package cn.melman.melleet;

import java.util.List;

public class Q024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode temp = newHead.next;
        newHead.next = head;
        newHead.next.next = null;
        ListNode cursor = newHead.next;
        ListNode second = null;
        while (true) {
            if (temp == null) {
                break;
            }
            if (second == null) {
                second = temp;
                temp = temp.next;
            } else {
                ListNode first = temp;
                temp = temp.next;
                cursor.next = first;
                first.next = second;
                second.next = null;
                cursor = second;
                second = null;
            }

        }
        if (second != null) {
            cursor.next = second;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildNode(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = new Q024().swapPairs(head);
        System.out.println(ListNode.printListNode(newHead).toString());
    }

}
