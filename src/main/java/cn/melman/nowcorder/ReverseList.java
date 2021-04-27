package cn.melman.nowcorder;

import cn.melman.melleet.ListNode;

/**
 * @author Melman
 * @date 2021/4/22 9:43 AM
 */
public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cursor = head.next;
        ListNode pre = head, temp;
        pre.next = null;
        while (cursor != null) {
            temp = cursor.next;
            cursor.next = pre;
            pre = cursor;
            cursor = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildNode(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = new ReverseList().ReverseList(head);
        ListNode.printListNode(listNode);
    }
}
