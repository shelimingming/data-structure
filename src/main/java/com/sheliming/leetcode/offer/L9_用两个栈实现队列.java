package com.sheliming.leetcode.offer;

import java.util.Stack;

public class L9_用两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public L9_用两个栈实现队列() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty()?-1:stack2.pop();
        } else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        L9_用两个栈实现队列 obj = new L9_用两个栈实现队列();
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
}
