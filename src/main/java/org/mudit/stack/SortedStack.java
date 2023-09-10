package org.mudit.stack;

import java.util.Stack;

public class SortedStack extends Stack<Integer> {
    private Stack<Integer> temp;

    public SortedStack() {
        super();
        temp = new Stack<>();
    }

    @Override
    public Integer push(Integer data) {
        if (isEmpty() || data <= peek()) {
            super.push(data);

        } else {

            while (!isEmpty() && data > peek()) {
                temp.push(pop());
            }

            super.push(data);

            while (!temp.isEmpty()) {
                super.push(temp.pop());
            }
        }
        return data;
    }
}
