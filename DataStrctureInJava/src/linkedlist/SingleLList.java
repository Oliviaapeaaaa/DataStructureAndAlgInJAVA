package linkedlist;

import adapter.LListAdapter;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class SingleLList<E> extends LListAdapter<E> {

    private static final long serialVersionUID = 1l;


    private  class Node{
       E value;
       Node next;
       Node(E value, Node next) {
           this.value  = value;
           this.next = next;
       }
    }
    private Node head;
    private int size;

    public SingleLList(){
        head = null;
        size = 0;
    }


    @Override
    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return this.size;
    }

    @Override
    public void clear(){ head = null;}
    @Override
    public E getFirst() {
        return head.value;
    }
    @Override
    public void addFirst(E value){
        Node newNode = new Node(value,head);
        newNode.next = head;
        newNode.value = value;
        head = newNode;
        size ++;
    }

    @Override
    public void addLast(E value){
        if (isEmpty()){
            addFirst(value);
            return;
        }

        Node newNode = new Node(value,null);
//        newNode.next = null;
//        newNode.value = value;


        Node last = this.head;
        while (last.next != null){
            last = last.next;
        }
        last.next = newNode;

        size ++;
    }

    @Override
    public boolean add(E value){
        addLast(value);
        return true;
    }

   @Override
    public void add(int index, E value){
        if (index < 0 || index > size){
            throw
                    new IndexOutOfBoundsException("index " + index + " size " + size);
        }

        Node newNode = new Node(value, head);
        Node cur = head;
//        locate the node at index position by crawling from left to right
        for (int counter = 0; counter < index - 1; counter ++){
            cur = cur.next;
        }
        Node temp = cur.next;
        cur.next = newNode;
        newNode.next = temp;
        size ++;

    }
    @Override
    public E removeFirst(){
        if (isEmpty()){
            throw
                    new NoSuchElementException();
        }
        E saved = head.value;

        head = head.next;
        size--;

        return saved;
    }

    @Override
    public E removeLast(){
         if (isEmpty()){
             throw
                     new NoSuchElementException();
         }

         Node cur = head;
        for (int counter = 0; counter < size - 2; counter ++){
            cur = cur.next;
        }
        E data = cur.next.value;
        cur.next = null;
        size --;
        return data;
    }

    @Override
    public boolean remove(Object obj){
        if (isEmpty()){
            throw
                    new NoSuchElementException();
        }
        Node cur = head;
        Node pre = null;
        while (cur.next != null){
            if (cur.value.equals(obj)){
                pre.next = cur.next;
                size --;
                return true;
            }
            pre = cur;
            cur = cur.next;
        }
        return false;

    }
    @Override
    public E remove(int index){

        if (isEmpty()){
            throw
                    new NoSuchElementException();
        }
        Node pre = null;
        Node cur = head;

        for (int counter = 0; counter < index; counter ++){
            pre = cur;
            cur = cur.next;
        }
        E data = cur.value;
        pre.next = cur.next;
        size --;
        return data;
    }

    public boolean search(Object obj){
        Node curNode  = this.head;
        while (curNode.next != null){
            if (curNode.value.equals(obj)){
                return true;
            }
            curNode = curNode.next;
        }
        return false;
   }

    @Override
    public String toString() {
        Iterator<E> iter = iterator();
        int i = 0;
        String str = "[";
        while(iter.hasNext()) {
            if (i++ != 0) {
                str += ", ";
            }
            str += iter.next();
        }
        str += "]";
        return str;
    }

    @Override
    public Iterator<E> iterator(){
        return new Iterator<E>() {
            private SingleLList.Node cur = head;
            @Override
            public boolean hasNext() {
                return cur!= null;
            }

            @Override
            public E next() {
                E data = (E) cur.value;
                cur = cur.next;
                return data;
            }
        };
    }
//   public void printList() {
//        if (isEmpty()) {
//            System.out.println("List is Empty!");
//            return;
//        }
//
//        Node temp = headNode;
//        System.out.print("List : ");
//
//        while (temp.nextNode != null) {
//            System.out.print(temp.data.toString() + " -> ");
//            temp = temp.nextNode;
//        }
//
//        System.out.println(temp.data.toString() + " -> null");
//    }








}
