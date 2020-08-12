package cn.melman.melleet;

public class Q025 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1) {
            return head;
        }
        int count = 0;
        ListNode res = null;
        ListNode cursor = null;
        ListNode[] arr = new ListNode[k];
        while (head != null) {
            arr[count] = new ListNode(head.val);
            if (count == k - 1) {
                for (; count >= 0; count--) {
                    if (res == null) {
                        res = arr[count];
                        cursor = res;
                    } else {
                        cursor.next = arr[count];
                        cursor = cursor.next;
                    }
                    arr[count] = null;
                }
                count = 0;
            } else {
                count++;
            }
            head = head.next;
        }
        for (count = 0; count < k; count++) {
            if (arr[count] == null) {
                continue;
            }
            if (res == null) {
                res = arr[count];
                cursor = res;
            } else {
                cursor.next = arr[count];
                cursor = cursor.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode listNode = new Q025().reverseKGroup(node, 2);
        while (true) {
            if (listNode == null) {
                break;
            }
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
