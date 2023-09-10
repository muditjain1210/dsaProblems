package org.mudit.queue;

//Queue Implemented using Linked List..
public class QueueLL<T> {

    private QueueNode<T> head;
    private QueueNode<T> tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T data) {
        QueueNode<T> node = new QueueNode<>();
        node.data = data;
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = tail;
        }

    }

    public T remove() {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return head.data;
    }

    @Override
    public String toString() {
        QueueNode<T> temp = head;
        StringBuilder builder = new StringBuilder();
        while (temp != null) {
            builder.append(temp.data + "->");
            temp = temp.next;
        }
        return builder.toString();
    }

    private static class QueueNode<T> {
        private QueueNode<T> next;
        private T data;
    }
}

class QueueEmptyException extends RuntimeException {

    public QueueEmptyException() {
        System.out.println("EMPTY QUEUE !!!!");
    }
}
