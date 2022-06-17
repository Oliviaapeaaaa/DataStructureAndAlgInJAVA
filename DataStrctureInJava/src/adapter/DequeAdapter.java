package adapter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class DequeAdapter<E>  implements Deque<E>, Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    // Iterator interface
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("iterator");
    }

    // Collection interface

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("add");
    }

    @Override
    public int size() { throw new UnsupportedOperationException("size"); }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("addAll");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("removeAll");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("containsAll");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("contains");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("isEmpty");
    }

    @Override
    public void clear() { throw new UnsupportedOperationException("clear"); }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("remove(Object)"); }

    @Override
    public<E> E[] toArray(E[] a) {
        throw new UnsupportedOperationException("toArray(a)");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("toArray");
    }

    // Queue interface

    @Override
    public E element() {
        throw new UnsupportedOperationException("element");
    }

    @Override
    public boolean offer(E e) {
        throw new UnsupportedOperationException("offer");
    }

    @Override
    public E peek() {
        throw new UnsupportedOperationException("peek");
    }

    @Override
    public E poll() {
        throw new UnsupportedOperationException("poll");
    }

    @Override
    public E remove() {
        throw new UnsupportedOperationException("remove()");
    }

    // Deque interface

    @Override
    public Iterator<E> descendingIterator() {
        throw new UnsupportedOperationException("descendingIterator");
    }

    @Override
    public void addFirst(E e) {
        throw new UnsupportedOperationException("addFirst");
    }

    @Override
    public void addLast(E e) {
        throw new UnsupportedOperationException("addLast");
    }

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("getFirst");
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("getLast");
    }

    @Override
    public boolean offerFirst(E e) {
        throw new UnsupportedOperationException("offerFirst");
    }

    @Override
    public boolean offerLast(E e) {
        throw new UnsupportedOperationException("offerLast");
    }

    @Override
    public E peekFirst() {
        throw new UnsupportedOperationException("peekFirst");
    }

    @Override
    public E peekLast() {
        throw new UnsupportedOperationException("peekLast");
    }

    @Override
    public E pollFirst() {
        throw new UnsupportedOperationException("pollFirst");
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException("pollLast");
    }

    @Override
    public E pop() {
        throw new UnsupportedOperationException("pop");
    }

    @Override
    public void push(E e) {
        throw new UnsupportedOperationException("push");
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("removeFirst");
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        throw new UnsupportedOperationException("removeFirstOccurrence");
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("removeLast");
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        throw new UnsupportedOperationException("removeLastOccurrence");
    }
}
