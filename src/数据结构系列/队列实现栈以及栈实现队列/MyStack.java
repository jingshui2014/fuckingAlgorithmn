package 数据结构系列.队列实现栈以及栈实现队列;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queueIn;
    Queue<Integer> queueOut;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queueIn = new LinkedList<>();
        queueOut = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queueIn.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queueIn.size() > 1) {
            while (queueIn.size() != 1) {
                queueOut.add(queueIn.poll());
            }
            return queueIn.poll();
        } else if (queueIn.size() == 1) {
            return queueIn.poll();
        } else if (!queueOut.isEmpty()) {
            Queue temp = queueOut;
            queueOut = queueIn;
            queueIn = temp;
            pop();
        }
        return -1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queueIn.size() > 1) {
            while (queueIn.size() != 1) {
                queueOut.add(queueIn.poll());
            }
            return queueIn.peek();
        } else if (queueIn.size() == 1) {
            return queueIn.peek();
        } else if (!queueOut.isEmpty()) {
            Queue temp = queueOut;
            queueOut = queueIn;
            queueIn = temp;
            pop();
        }
        return -1;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queueIn.isEmpty() && queueOut.isEmpty();
    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
    }
}
