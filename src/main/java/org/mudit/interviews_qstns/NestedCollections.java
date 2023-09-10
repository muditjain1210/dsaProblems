package org.mudit.interviews_qstns;

import java.util.ArrayList;
import java.util.Iterator;

public class NestedCollections<T> implements Iterable<T> {

    public ArrayList<T> arrayList;
    public NestedCollections<T> innerList;
    public NestedCollections<T> next; // pointer to next list

    public NestedCollections() {
    }

    public NestedCollections(NestedCollections<T> next) {
        this.next = next;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        Iterator<T> arrayListItr = null;
        Iterator<T> inneritr = null;

        Itr() {
            this.arrayListItr = arrayList.iterator();
            if (innerList != null) {
                this.inneritr = innerList.iterator();
            }
        }

        @Override
        public boolean hasNext() {
            // first process array list
            if (arrayListItr.hasNext()) {
                return true;
            }
            // check if inner list is null
            if (inneritr == null) {
                return false;
            }
            // inner list is not null, recursively call hasNext() on inner list.
            return inneritr.hasNext();
        }

        @Override
        public T next() {
            // process ArrayList first
            if (arrayListItr.hasNext()) {
                return arrayListItr.next();
            }
            // check if inner list is null
            if (inneritr == null) {
                return null;
            }
            // inner list is not null, recursively call next() on inner list.
            return inneritr.next();
        }

    }
}

class Driver {
    public static void main(String args[]) {
        NestedCollections<Integer> n4 = new NestedCollections<>(null);
        NestedCollections<Integer> n3 = new NestedCollections<>(n4);
        NestedCollections<Integer> n2 = new NestedCollections<>(n3);
        NestedCollections<Integer> n1 = new NestedCollections<>(n2);

        // N1
        n1.arrayList = new ArrayList<>();
        n1.arrayList.add(1);
        n1.innerList = null;

        // N2
        n2.arrayList = new ArrayList<>();
        n2.arrayList.add(4);
        n2.arrayList.add(11);
        n2.innerList = null;

        // N3
        n3.arrayList = new ArrayList<>();
        n3.arrayList.add(3);
        n3.arrayList.add(7);

        n3.innerList = new NestedCollections<>();
        {
            n3.innerList.arrayList = new ArrayList<>();
            n3.innerList.arrayList.add(5);
            n3.innerList.arrayList.add(6);
        }

        // N4
        n4.arrayList = new ArrayList<>();
        n4.arrayList.add(7);

        n4.innerList = new NestedCollections<>();
        {
            n4.innerList.arrayList = new ArrayList<>();
            n4.innerList.arrayList.add(8);
            {
                n4.innerList.innerList = new NestedCollections<>();
                n4.innerList.innerList.arrayList = new ArrayList<>();
                n4.innerList.innerList.arrayList.add(9);
                n4.innerList.innerList.arrayList.add(10);

            }
        }

        // TEST DRIVE...............
        NestedCollections<Integer> temp = n1;
        while (temp != null) {
            Iterator<Integer> it = temp.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            temp = temp.next;
        }
    }
}