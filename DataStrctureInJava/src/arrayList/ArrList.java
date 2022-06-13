package arrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrList<E> extends AListAdapter<E>{
//    function in there should match to AListAdapter
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private E[] data;

    public ArrList(int capacity){
        data = (E[]) new Object[capacity];
    }// primary constructor
    public ArrList() {
        this(DEFAULT_CAPACITY);
    } // If a user doesn't care to specify the capacity
    @SuppressWarnings("unchecked")
    public void resize(int new_capacity){
        if (size <= data.length){
            return;
        }
       E[] newData = (E[]) new Object[new_capacity];

        for (int i = 0; i < newData.length; i ++){
            newData[i] = data[i];
        }
        data = newData;

    }

    @SuppressWarnings("unchecked")
    public boolean add(E e){
        // dds to the array's end
        if (size == data.length){
            resize(data.length * 2); // paramemts must be integer
        }

        data[size ++] = e;
//        size ++; //  if exist, the size will be twice
        return true;
    } // O(1),

    public  int size(){ return size;}

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int index) {
        if ( index < 0 || index > size){
            throw new IndexOutOfBoundsException("index is out of bound");
        }
        return data[index];
    }

    public E set(int index, E elt){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("no such index");
        }
        E original = data[index];
        data[index] = elt;
        return  original;
    }


    public void clear(){
        size = 0;
    }

    @Override
    public void ensureCapacity(int mincapacity){
        resize(mincapacity);
    }

    public Object[] toArray(){
        return Arrays.copyOf(data, size);
    }
    public String toString(){
        return Arrays.toString(this.toArray());
    }
    @SuppressWarnings("unchecked")
    public ListIterator<E> listIterator(){
        return Arrays.asList((E[]) toArray()).listIterator();
    }

    public Iterator<E> iterator(){return listIterator(); }

    public void add(int index, E elt){
        if (size ==  data.length){
            resize(2 * data.length);
        }
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + "size: " + size);
        }
        for (int i = size - 1; i >= index; i --){
            data[i + 1] = data[i];
        }
        data[index] = elt; // after for loop, else the added element will be duplicated
        size ++;
    }

    public int indexOf(Object obj){
        // equals function implicitly assumes that there are no null values
        if (isEmpty()){
            System.out.println("Empty");
        }
        if (obj == null){
            for (int i = 0; i < size; i ++){
                if (data[i] == null){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i ++){
                if (data[i].equals(obj)){
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj){
        if (isEmpty()){
            System.out.println("Empty");
        }

        if (obj == null){
            for (int i = size - 1; i >= 0; i --){
                if (data[i] == null){
                    return i;
                }
            }

        }
        else{
            for (int i = size - 1; i >= 0; i --){
                if (data[i].equals(obj)){
                    return i;
                }
            }
        }

        return -1;

    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    public boolean remove(Object obj){
        if (isEmpty()){
            System.out.println("Empty");
        }
        int i = indexOf(obj);
        if (i == -1){
            return false;
        }
        this.reomve(i);
        return true;
    }
    public void reomve(int index){
        if ( index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index" + index + ","+ "Size" + size);
        }
        for (int i = index ; i < size; i --){
            data[i] = data[i + 1];
        }
        size --;
    }
}
