package cn.melman.melleet;

import java.util.HashSet;

public class Q141 {


    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> node = new HashSet<>();
        while (true) {
            if (head == null) {
                return false;
            }
            if (node.contains(head)) {
                return true;
            }
            node.add(head);
            head = head.next;
        }
    }

}
