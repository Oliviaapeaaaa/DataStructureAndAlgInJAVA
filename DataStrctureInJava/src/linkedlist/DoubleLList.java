package linkedlist;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Iterator;

public class DoubleLList<E> extends LListAdapter<E> {
    private static final long serialVersionUID = 1l;

    private class Node<E>{
        E data;
        Node next;
        Node prev;
       Node(Node prev, E data, Node next){
           this.prev = prev;
           this.data = data;
           this.next = next;


       }

    }
    private Node head;
    private Node last;
    private int size;

    private void makeNewList() {
        head = new Node<E>(null, null, null);
        last = new Node<E>(null, null, null);
        head.next = last;
        last.prev = head;
        size = 0;
    }

    public DoubleLList(){
        this.makeNewList();
    }
    @Override
    public int size(){ return this.size;}
    @Override
    public boolean isEmpty(){return head == null;}
    @Override
    public void clear(){
        head = null;
    }
    @Override
    public String toString(){
        return Arrays.toString(this.toArray());
    }
    @Override
    public Iterator<E> iterator(){
        return
                new Iterator<E>() {
            private DoubleLList.Node cur = head.next;
                    @Override
                    public boolean hasNext() {
                        return cur != last;
                    }

                    @Override
                    public E next() {
                        E data = (E) cur.data;
                        cur = cur.prev;
                        return data;

                    }
                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
    }
    
 






}
