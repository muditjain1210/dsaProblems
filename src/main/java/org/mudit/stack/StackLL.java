package org.mudit.stack;

//Stack Implemented using a Linked List..
public class StackLL<T> {

    private static class StackNode<T> {
        private StackNode<T> next;
        private T data;
    }

    private StackNode<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        StackNode<T> node = new StackNode<>();
        node.data = data;
        node.next = top;
        top = node;
    }

    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return top.data;
    }

    @Override
    public String toString() {
        StackNode<T> temp = top;
        StringBuilder builder = new StringBuilder();
        while (temp != null) {
            builder.append(temp.data + "->");
            temp = temp.next;
        }
        return builder.toString();
    }
}

class StackEmptyException extends RuntimeException {

    public StackEmptyException() {
        System.out.println("EMPTY STACK !!!!");
    }
}
