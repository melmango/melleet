package cn.melman.melleet;

import java.util.List;

/**
 * @author Melman
 * @date 2021/3/26 11:51 AM
 */
public class Q082 {

    /**
     * 写的有点儿磨叽了，弄了一堆指针和判断
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        ListNode temp = head;
        ListNode pre = null;
        ListNode first = null;
        boolean found = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (first == null) {
                first = temp;
                found = false;
            } else {
                if (temp.val == first.val) {
                    found = true;
                    if (res != null && temp.val == res.val) {
                        res = null; //如果第一个是重复的一样，头就不要了
                    }
                } else {//第一个不相同的节点
                    if (found) {
                        if (pre == null) {
                            res = temp;
                        } else {//真正断指针的地方，在第一个不相同的节点的下一个节点先接上，如果这个还有的话，还得再断开，所以pre不能轻易移动
                            pre.next = temp;
                        }
                    } else {
                        if (res == null) {
                            res = head;
                        }
                        pre = first;//只有当纯的不重复的节点，才敢移动pre
                    }
                    first = temp;
                    found = false;
                }
            }
            temp = temp.next;
        }
        if (found && pre != null) {//结尾检测
            pre.next = null;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode res = new Q082().deleteDuplicates(ListNode.buildNode(new int[]{1, 1, 2, 2}));
        System.out.println(ListNode.printListNode(res).toString());

    }
}
