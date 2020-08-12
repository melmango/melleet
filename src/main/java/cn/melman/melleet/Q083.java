package cn.melman.melleet;

import java.util.HashSet;

/**
 * 删除链表重复项
 */
public class Q083 {

    //题目中是排序链表，没考虑已经排序好了
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cursor = head.next;
        ListNode last = head;
        while (cursor != null) {
            if (cursor.val == last.val) {
                last.next = cursor.next;
            } else {
                last = cursor;
            }
            cursor = cursor.next;
        }
        return head;
    }

    //题目中是排序链表，没考虑已经排序好了
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode cursor = head.next;
        ListNode last = head;
        while (cursor != null) {
            if (set.contains(cursor.val)) {
                last.next = cursor.next;
            } else {
                set.add(cursor.val);
                last = cursor;
            }
            cursor = cursor.next;
        }
        return head;
    }
}

