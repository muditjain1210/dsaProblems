package org.mudit.stack;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks<T> {
    public ArrayList<Stack<T>> setOfStack;
    private int threshold;

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    public void push(T data) {

    }

    public T pop() {
        return null;
    }

    private Stack<T> getLastStack() {
        if (setOfStack.size() == 0) {
            return null;
        }
        return setOfStack.get(setOfStack.size() - 1);
    }
}
