package cn.melman.melleet;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Q019 {

    public ListNode removeNthFromEnd_slow(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        List<ListNode> nodes = new ArrayList<>();
        ListNode temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            nodes.add(temp);
            temp = temp.next;
        }
        if (n > nodes.size()) {
            return head;
        }
        if (n == 1) {
            nodes.get(nodes.size() - n - 1).next = null;
        } else if (n == nodes.size()) {
            return head.next;
        } else {
            nodes.get(nodes.size() - n - 1).next = nodes.get(nodes.size() - n + 1);
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode first = head;
        int fill = 0;
        while (true) {
            if (temp == null) {
                break;
            }
            if (fill < n + 1) {
                fill++;
            } else {
                first = first.next;
            }
            temp = temp.next;
        }
        if (fill == n) {
            //如果就是要删除第一个
            return head.next;
        }
        if (fill < n) {
            //如果不够就算了
            return head;
        }
        if (first.next != null) {
            //如果不是最后一个
            first.next = first.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(ListNode.printListNode(head).toString());
        ListNode res = new Q019().removeNthFromEnd(head, 5);
        System.out.println(ListNode.printListNode(res).toString());
    }

}
