package cn.melman.melleet;

public class Q023 {

    // 慢
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode res = null;
        ListNode cursor = null;
        int minIndex;
        int len = lists.length;
        for (; ; ) {
            minIndex = -1;
            for (int i = 0; i < len; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minIndex < 0 || lists[minIndex].val > lists[i].val) {
                    minIndex = i;
                }
            }
            if (minIndex < 0) {
                break;
            } else {
                if (res == null) {
                    res = lists[minIndex];
                    cursor = res;
                } else {
                    cursor.next = lists[minIndex];
                    cursor = cursor.next;
                }
                lists[minIndex] = lists[minIndex].next;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        ListNode node = new Q023().mergeKLists(new ListNode[]{node1, node2, node3});
        while (true) {
            System.out.println(node.val);
            if (node.next != null) {
                node = node.next;
            } else {
                break;
            }
        }
    }
}
