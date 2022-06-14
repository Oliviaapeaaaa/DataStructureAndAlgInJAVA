package linkedlist;

import org.w3c.dom.Node;

import java.util.NoSuchElementException;
public class SingleLList<E> extends LListAdapter<E>{

    private static final long serialVersionUID = 1l;


    private static class Node<E>{
       E value;
       Node<E> next;
       Node(E value, Node<E> next) {
           this.value  = value;
           this.next = next;
       }



    }
    private Node<E> head;
    private int size;

    public SingleLList(){
        head = null;
        size = 0;
    }


    @Override
    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public void clear(){ head = null;}

    public Node getHead() {
        return head;
    }
    @Override
    public void addFirst(E value){
        Node newNode = new Node<E>(value,head);
        newNode.next = head;
        newNode.value = value;
        head = newNode;
        size ++;
    }

    public void addLast(E value){
        if(isEmpty()){
            addFirst(value);
        }

        Node newNode = new Node<>(value,null);
        newNode.value = value;
        newNode.next = null;
        Node last = head;
        while (last.next != null){
            last = head.next;
        }
        last.next = newNode;
        size ++;
    }

    public boolean add(E value){
        addLast(value);
        return true;
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

//   public boolean search(Object obj){
//        Node curNode  = this.head;
//        while (curNode.next != null){
//            if (curNode.value.equals(obj)){
//                return true;
//            }
//            curNode = curNode.next;
//        }
//        return false;
//   }




}
