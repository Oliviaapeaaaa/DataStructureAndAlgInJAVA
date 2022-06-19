package TreeSet;

import adapter.NavSetAdapter;

import java.util.Comparator;

public class SearchTreeSet<E> extends NavSetAdapter<E> {
    private static final long serialVerisionaUID = 1L;

    private static class Node<E>{
        E data;
        Node<E> right;
        Node<E> left;

        Node(E data, Node<E> left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

    private Node<E> root = null;
    private int size = 0;
    private Comparator<? super E> cmp = null;

    public SearchTreeSet(Comparator<? super E> cmp){
        this.cmp = cmp;
    }

    public SearchTreeSet(){

    }

    @SuppressWarnings("unchecked")
//     Comparable<E> interface: e1.compareTo(e2)
//    < 0  means e1 is less that e2
//    = 0  means that e1 equals e2
//    > 0  means that e1 is greater than e2
//    Comparator<E>:
//                    < 0  means e1 is less that e2
//cmp.compare(e1,e2)  = 0  means that e1 equals e2
//                    > 0  means that e1 is greater than e2
    private int myCompare(E lhs, E rhs){
        if (cmp == null){
            return ((Comparable<E>) lhs).compareTo(rhs);
        }else {
            return cmp.compare(lhs,rhs);
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void clear(){
        root = null;
        size = 0;
    }

    @Override
    public boolean isEmpty(){
        return root == null;
    }

    @Override
    public Comparator<? super E> comparator(){
        return cmp;
    }
// recursion
    public boolean contains(Node<E> n, E elt){
        if (n == null){
            return false;
        }
        int comp = myCompare(elt, n.data);

        if (comp < 0){
            return contains(n.left, elt);
        } else if (comp > 0){
            return contains(n.right, elt);
        } else {
            return true;
        }

    }
//     iterator
    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object obj){
        E elt = (E) obj;
        Node<E> n = root;
        while (n != null){
            int comp = myCompare(elt, n.data);
            if(comp < 0){
                n = n.left;
            } else if (comp > 0){
                n = n.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // The add function
     // must return false if elt is already in the tree,and true if not, in which case it will add the element into a new leaf node.

    public Node<E> add(Node<E> n, E elt){
        if ( n == null){
             return new Node<>(elt, null, null);
        }
        int comp = myCompare(elt, n.data);
        if (comp < 0){
            // n.left, because we insert a node in the vacant location to modify the left subtree
            Node<E> node= add(n.left, elt);
            // BP
            n.left = node;
            // the return value n is the root
            return n;
        } else if (comp > 0){
           n.right = add(n.right, elt);
           return n;
        }
        return n;
    }
// The add function as well as contains are considered to be logarithmic time, i.e. O(log(n)). This of course, assumes that the tree is "well balanced" in some sense, however, in any realistic implementation, this will be the case.
//What can specifically be said is this: the average time to do add or contains in an average binary tree is O(log(n)).
    public boolean add(E elt){
        if (this.contains(elt)){
            return  false;
        }
        root = add(root, elt);
        size ++;
        return true;
    }









}
