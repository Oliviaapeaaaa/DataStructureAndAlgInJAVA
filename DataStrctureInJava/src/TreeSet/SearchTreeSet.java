package TreeSet;

import adapter.NavSetAdapter;
import org.w3c.dom.Node;

import java.util.*;

public class SearchTreeSet<E> extends NavSetAdapter<E> {
    private static final long serialVersionUID = 1L;

    private static class Node<E> {
        E data;
        Node<E> left, right;

        Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private Node<E> root = null;
    private int size = 0;
    private Comparator<? super E> cmp = null;

    public SearchTreeSet(Comparator<? super E> cmp) {
        this.cmp = cmp;
    }

    public SearchTreeSet() {
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

    private Node<E> add(Node<E> n, E elt){
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
//Wh
// at can specifically be said is this: the average time to do add or contains in an average binary tree is O(log(n)).
   @Override
    public boolean add(E elt){
        if (this.contains(elt)){
            return  false;
        }
        root = add(root, elt);
        size ++;
        return true;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean ret = false;
        for(E elt: c) {
            ret |= add(elt);
        }
        return ret;
    }

    public E findMin(Node<E> n){
        if (n.left == null){
            return n.data; // ecpected to get from the left child
        } else {
           return findMin(n.left);
        }
    }

    public E findMax(Node<E> n){
        if(n.right == null){
            return n.data;
        } else {
            return findMin(n.right);
        }
    }

// always choosing "removeMin on the right" can cause a "left-skewing" effect.
//  outcome of O(n2) insert/delete pairs in a random tree created from O(n) initial insertions
    private Node<E> removeMin(Node<E> n){
        if (n.left == null){
            return n.right;
        } else {
            n.left = removeMin(n.left);
            return n;
        }
    }

    private Node<E> removeMax(Node<E> n){
        if (n.right == null){
            return n.left;
        } else {
            n.right = removeMin(n.right);
            return n;
        }
    }

    // randamely use removeMin and removMax to remove

    private final Random flipAcoin = new Random();
// The remove, removeMax and removeMin functions,
// and thus are also considered to be logarithmic time.
    private Node<E> remove(Node<E> n, E elt){
        if (n == null){
            return null;
        }
        int comp = myCompare(elt, n.data);
        if (comp < 0){
            n.left = remove(n.left, elt);
            return n;
        }
        if (comp > 0){
            n.right = remove(n.right, elt);
            return n;
        }

        if (n.left == null){
            return n.right;
        }

        if (n.right == null){
            return n.left;
        }
        boolean chose_min = (flipAcoin.nextInt(2) == 1);

        if (chose_min){
            n.data = findMin(n.right);
            n.right = removeMin(n.right);
        } else {
            n.data = findMax(n.left);
            n.left = removeMax(n.left);
        }

        return n;

    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object obj){
        E elt = (E) obj;
        if (this.contains(elt)){
            root = remove(root, elt);
            size--;
            return true;
        }
        return false;
    }


    // structure-revealing operations
    private String indentString = "   ";

    public void setIndentString(String indentString) {
        this.indentString = indentString;
    }

    public void inorderOutput() {
        inorderOutput(root, 0);
    }

    public void reverseInorderOutput() {
        reverseInorderOutput(root, 0);
    }

    public void preorderOutput() {
        preorderOutput(root, 0);
    }

    public void postorderOutput() {
        postorderOutput(root, 0);
    }

    private String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }

    private void inorderOutput(Node<E> n, int level) {
        if (n != null) {
            inorderOutput(n.left, level + 1);
            System.out.println(repeat(indentString, level) + n.data);
            inorderOutput(n.right, level + 1);
        }
    }

    private void reverseInorderOutput(Node<E> n, int level) {
        if (n != null) {
            reverseInorderOutput(n.right, level + 1);
            System.out.println(repeat(indentString, level) + n.data);
            reverseInorderOutput(n.left, level + 1);
        }
    }

    private void preorderOutput(Node<E> n, int level) {
        if (n != null) {
            System.out.println(repeat(indentString, level) + n.data);
            preorderOutput(n.left, level + 1);
            preorderOutput(n.right, level + 1);
        }
    }

    private void postorderOutput(Node<E> n, int level) {
        if (n != null) {
            postorderOutput(n.left, level + 1);
            postorderOutput(n.right, level + 1);
            System.out.println(repeat(indentString, level) + n.data);
        }
    }

    private int toArray(Object[] arr, int index, Node<E> n) {
        if (n == null) {
            return index;
        }
        else {
            index = toArray(arr, index, n.left);
            arr[index++] = n.data;
            return toArray(arr, index, n.right);
        }
    }

    @Override
    public Object[] toArray() {
        Comparable[] arr = new Comparable[size];
        toArray(arr, 0, root);
        return arr;
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(toArray());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return Arrays.asList((E[]) toArray()).listIterator();
    }

}
