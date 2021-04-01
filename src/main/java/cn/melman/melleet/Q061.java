package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/3/27 3:16 PM
 */
public class Q061 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int length = 0;
        while (true) {
            length++;
            if (temp.next == null) {
                if (length == k) {//如果移动一边长，就不移动了
                    return head;
                }
                temp.next = head;//先把尾巴接上，在找地方断开就行了
                break;
            }
            temp = temp.next;
        }

        length = length - k % length;
        temp = head;
//        length = 0;
        while (true) {
            length--;
            if (length == 0) {//下一个为头，这一个断开即可，因为上面尾巴已经接上了
                ListNode res = temp.next;
                temp.next = null;
                return res;
            }
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        ListNode res = new Q061().rotateRight(ListNode.buildNode(new int[]{1, 2, 3, 4, 5}), 2);
        System.out.println(ListNode.printListNode(res).toString());
    }
}
