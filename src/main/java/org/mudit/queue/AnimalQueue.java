package org.mudit.queue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class AnimalQueue {
    private int count = 0;
    private Queue<Animal> dogs;
    private Queue<Animal> cats;

    public AnimalQueue() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();

    }

    public void enqueue(Mammal type) {
        count++;
        if (type == Mammal.CAT) {
            cats.add(new Animal(Mammal.CAT, count));
        }
        if (type == Mammal.DOG) {
            dogs.add(new Animal(Mammal.DOG, count));
        }
    }

    public Animal dequeue() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            throw new EmptyStackException();
        }

        if (dogs.isEmpty()) {
            return cats.remove();
        }
        if (cats.isEmpty()) {
            return dogs.remove();
        }

        if (dogs.peek().stamp < cats.peek().stamp) {
            return dogs.remove();
        }
        return cats.remove();
    }

    public Animal catdequeue() {

        return cats.remove();
    }

    public Animal dogdequeue() {

        return dogs.remove();
    }

    private class Animal {
        @Override
        public String toString() {
            return "Animal [type=" + type + ", stamp=" + stamp + "]";
        }

        private Mammal type;
        private int stamp;

        private Animal(Mammal type, int stamp) {
            this.type = type;
            this.stamp = stamp;
        }
    }

}

enum Mammal {
    CAT,
    DOG
}
