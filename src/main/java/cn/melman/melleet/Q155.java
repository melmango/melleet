package cn.melman.melleet;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Melman
 * @date 2021/4/13 10:24 AM
 */
public class Q155 {

    /**
     * 跟Offer59是一样的
     * 但是坑就在这里，59题是链表，这个是栈，Stack，用链表试了半天，都不行，用栈轻松解决
     *
     * 解决思路就是往栈里放入的时候，同时放入一个当前最小的值。这样一起pop就不会有问题
     */
    static class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();


        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            if (!minStack.isEmpty() && val > minStack.lastElement()) {
                minStack.push(minStack.lastElement());
            } else {
                minStack.push(val);
            }
        }

        public void pop() {
            Integer pop = stack.pop();
            if (pop != null) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.lastElement();
        }

        public int getMin() {
            return minStack.lastElement();
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-10);
        stack.push(14);
        System.out.println(stack.getMin());
        System.out.println(stack.getMin());
        stack.push(-20);
        System.out.println(stack.getMin());
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(10);
        stack.push(-7);
        System.out.println(stack.getMin());
        stack.push(-7);
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
    }

}
