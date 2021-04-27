package cn.melman.melleet;

import java.util.LinkedList;

/**
 * @author Melman
 * @date 2021/4/13 9:53 AM
 */
public class Offer59 {

    /**
     * 双列表还真实巧妙啊，最大的poll出去也就拉倒了
     * 要求max和pop是O(1)，就的在插入上下功夫了
     */
    class MaxQueue {

        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            if (maxQueue.isEmpty()) {
                return -1;
            }
            return maxQueue.getFirst();
        }

        public void push_back(int value) {
            queue.push(value);
            while (!maxQueue.isEmpty() && maxQueue.getLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            Integer res = queue.poll();
            if (res.equals(maxQueue.getFirst())) {
                maxQueue.poll();
            }
            return res;
        }
    }


}
