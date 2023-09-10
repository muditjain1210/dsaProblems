package org.mudit.generic;

import java.util.Iterator;

//Special Iterator which iterates over alternate elements..
public class MyIterator<E> implements Iterator<E> {
    Iterator<E> iter;
    boolean skip;

    public MyIterator(Iterator<E> e) {
        this.iter = e;
        skip = false;
    }

    @Override
    public boolean hasNext() {
        if (skip) {
            iter.next();
            skip = false;
            return iter.hasNext();
        }
        return iter.hasNext();
    }

    @Override
    public E next() {
        if (skip) {
            iter.next();
            return iter.next();
        }

        if (!skip) {
            skip = true;
            return iter.next();
        }
        return null;
    }

}
