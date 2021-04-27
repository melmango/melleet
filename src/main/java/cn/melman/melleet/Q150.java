package cn.melman.melleet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Melman
 * @date 2021/4/21 10:55 AM
 */
public class Q150 {

    public int evalRPN(String[] tokens) {
        int i = 0;
        Integer temp;
        Deque<Integer> deque = new LinkedList<>();
        while (i < tokens.length) {
            if (tokens[i].length() == 1) {
                switch (tokens[i].charAt(0)) {
                    case '+':
                        deque.push(deque.pop() + deque.pop());
                        break;
                    case '-':
                        temp = deque.pop();
                        deque.push(deque.pop() - temp);
                        break;
                    case '*':
                        deque.push(deque.pop() * deque.pop());
                        break;
                    case '/':
                        temp = deque.pop();
                        deque.push(deque.pop() / temp);
                        break;
                    default:
                        //数字
                        deque.push(Integer.valueOf(tokens[i]));
                        break;
                }
            } else {
                deque.push(Integer.valueOf(tokens[i]));
            }
            i++;
        }
        return deque.pop();
    }

    private void calc(int type, Deque<Integer> queue) {
        Integer num1 = queue.pop();
        Integer num2 = queue.pop();
        switch (type) {
            case 1:
                queue.push(num1 + num2);
                break;
            case 2:
                queue.push(num1 - num2);
                break;
            case 3:
                queue.push(num1 * num2);
                break;
            case 4:
                queue.push(num2 / num1);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        int res = new Q150().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(res);
    }

}
