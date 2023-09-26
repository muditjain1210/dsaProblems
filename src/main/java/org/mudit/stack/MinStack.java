package org.mudit.stack;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> mainStack;
    private final Stack<Integer> minStack;

    public MinStack(Stack<Integer> mainStack, Stack<Integer> minStack) {
        super();
        this.mainStack = mainStack;
        this.minStack = minStack;
    }

    public void push(int num) {
        // first time put first element o both stack
        if (minStack.peek() >= num) {
            minStack.push(num);
        }
        mainStack.push(num);
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            int i = mainStack.peek();
            if (minStack.peek() == i) {
                minStack.pop();
            }
            mainStack.pop();
        }
    }

    public int getMin() {
        return minStack.peek();
    }

}
