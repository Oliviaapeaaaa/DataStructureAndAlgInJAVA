package linkedlist;

import java.util.Deque;
public class LLDemo {
    public static void main(String[] args) {
   Deque<String> L = new SingleLList<>();
//    Deque<String> L = new DoubleLList<>();

        for (String str : new String[]{"aaa", "bbb", "ccc", "ddd", "zzz"}) {
            L.addFirst(str);
        }
        System.out.println(L);
         for (String s : L){
             System.out.println( s + "" );
         }
         System.out.println();
         System.out.println(L.getFirst());
         System.out.println();

         System.out.println(((SingleLList<String>) L).search("ddd"));
        System.out.println();
        System.out.println(L.removeFirst());
        System.out.println("After remove first node : " + L);

        L.addLast("s");
        System.out.println(L);

        ((SingleLList<String>) L).add(1,"iii");
        System.out.println("after insert at 1 : " + L);
        System.out.println("remove last : " + L.removeLast());
        System.out.println(L);

        System.out.println();
        ((SingleLList<String>) L).remove("iii");
        System.out.println("after reomve \"iii\" "  + L);

        ((SingleLList<String>) L).remove(2);
        System.out.println("after reomve index at 2 "  + L);
        System.out.println(L.size());

    }
}
