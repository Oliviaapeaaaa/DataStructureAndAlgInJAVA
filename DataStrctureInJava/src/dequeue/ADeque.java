package dequeue;

import adapter.DequeAdapter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ADeque<E> extends DequeAdapter<E> {
    // use Array
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
//    low: array position of data for the getFirst,addFirst,removeFirst operations
    private int low;
//    high: array position after data for getLast,addLast,removeLast operations
    private int high;
    private int size;

    @SuppressWarnings("unchecked")
    public ADeque(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
        low = 0;
        high = 0;

    }

    public ADeque(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty(){return size == 0;}

    private int inc(int x){
        return (x == data.length - 1) ? 0 : x + 1;
    }

    private int dec(int x){
        return (x == 0) ? data.length - 1 : x - 1;
    }


    @SuppressWarnings("unchecked")
    private void increaseCapacity(int new_capacity){
        if (new_capacity <= data.length){
            return;
        }

        E[] new_data = (E[]) new Object[new_capacity];
        int index = low;
        for (int i = 0; i < data.length; i ++){
            new_data[i] = data[index];
            index = inc(index);
        }
        low = 0;
//        orginal data. length
        high = data.length;
        data = new_data;
    }

    @Override
    public void addFirst(E elt){
        // DequeAdapter<E>, if there is no<E>, then only (Object obj) can be passed
        if (size == data.length){
            increaseCapacity(2 * data.length);
        }

        low = dec(low);
        data[low] = elt;
        size ++;
    }
    @Override
    public void addLast(E elt){
        if (size == data.length){
            increaseCapacity(2 * data.length);
        }
//        assignment first then dec, low is dec first and then assignment, so there is no elemenmt at index 0
        data[high] = elt;
        high = inc(high);
        size ++;
    }

    @Override
    public E getFirst(){
        if (isEmpty()){
            throw
                    new NoSuchElementException();
        }
        return data[low];
    }
    @Override
    public E getLast(){
        if (isEmpty()){
            throw
                    new NoSuchElementException();
        }
        return data[dec(high)];
    }

    @Override
    public E removeFirst(){
        if (isEmpty()){
            throw
                    new NoSuchElementException();
        }
        E saved = data[low];
        low = inc(low);
        size --;
        return saved;
    }

    @Override
    public E removeLast(){
        if (isEmpty()){
            throw
                    new NoSuchElementException();
        }
//        High position is after the last index of the array
        E saved = data[high--];
        high = dec(high);
        size --;
        return saved;

    }

    @Override
    public Object[] toArray(){
        Object[] myArray = new Object[size];
        int i = 0;
        for (E elt: this) {                // for loop runs iterator
            myArray[i++] = elt;
        }
        return myArray;
    }

    @Override
    public String toString() { return Arrays.toString( toArray() ); }

    @Override
    public Iterator<E> iterator(){
        return new Iterator<E>() {
            int pos = low;
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E value = data[pos];
                pos = inc(pos);
                ++count;
                return value;
            }
            @Override
            public void remove() { throw new UnsupportedOperationException(); }
        };

    }

    @Override
    public boolean add(E elt) { this.addLast(elt); return true; }

    @Override
    public void push(E elt) { this.addFirst(elt); }

    @Override
    public E pop() { return this.removeLast(); }

    @Override
    public E remove() { return this.removeFirst(); }

    @Override
    public E element() { return this.getFirst(); }

    public String info() {
        return String.format(
                "cap=%s, size=%s, low=%s, high=%s\ndata=%s",
                data.length, size, low, high, Arrays.toString(data))
                ;
    }


}
