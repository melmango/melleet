package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

public class Q002 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cursor = res;
        ListNode last1 = l1;
        ListNode last2 = l2;
        boolean addOne = false;
        while (true) {
            int v1 = last1 == null ? 0 : last1.val;
            int v2 = last2 == null ? 0 : last2.val;
            int value = v1 + v2 + (addOne ? 1 : 0);
            if (value >= 10) {
                value = value - 10;
                addOne = true;
            } else {
                addOne = false;
            }
            cursor.next = new ListNode(value);
            cursor = cursor.next;
            last1 = last1 == null ? null : last1.next;
            last2 = last2 == null ? null : last2.next;
            if (last1 == null && last2 == null) {
                if (addOne) {
                    cursor.next = new ListNode(1);
                }
                break;
            }
        }
        return res.next;
    }

    private void sum(List<Integer> target, ListNode l1, ListNode l2, boolean addOne) {
        int value = addOne ? 1 : 0;
        ListNode next1 = null;
        ListNode next2 = null;
        if (l1 != null) {
            value = value + l1.val;
            next1 = l1.next;
        }
        if (l2 != null) {
            value = value + l2.val;
            next2 = l2.next;
        }
        if (next1 == null && next2 == null && value == 0) {
            return;
        }
        if (value >= 10) {
            target.add(value - 10);
        } else {
            target.add(value);
        }
        if (l1 == null && l2 == null) {
            return;
        }
        sum(target, next1, next2, value >= 10);
    }


    private void appendNode(ListNode node, ArrayList<Integer> arr, int index) {
        if (index >= arr.size()) {
            return;
        }
        ListNode next = new ListNode(arr.get(index));
        node.next = next;
        appendNode(node.next, arr, index + 1);
    }

    public static void main(String[] args) {
        Q002 q2 = new Q002();
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(3);
        arr1.add(4);
        arr1.add(2);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(4);
        arr2.add(6);
        arr2.add(5);
        ListNode l1 = q2.getNode(arr1);
        ListNode l2 = q2.getNode(arr2);
        ListNode ret = new Q002().addTwoNumbers(l1, l2);
        System.out.println(ret);
    }

    private ListNode getNode(ArrayList<Integer> arr) {
        if (arr.isEmpty() || arr.isEmpty()) {
            return new ListNode(0);
        }
        ListNode node = new ListNode(arr.get(0));
        appendNode(node, arr, 1);
        return node;
    }
}
