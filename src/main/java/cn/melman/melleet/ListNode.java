package cn.melman.melleet;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static StringBuilder printListNode(ListNode head) {
        ListNode temp = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (true) {
            if (temp == null) {
                sb.append("]");
                break;
            }
            sb.append(temp.val);
            if (temp.next != null) {
                sb.append(',');
            }
            temp = temp.next;
        }
        return sb;
    }

    public static ListNode buildNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode temp = new ListNode(arr[0]);
        ListNode head = temp;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = temp.next;
        }
        return head;
    }

}