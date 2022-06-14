package linkedlist;

import java.util.Deque;

public class LLDemo {
    public static void main(String[] args) {
        Deque<String> list = new SingleLList<>();
         for (String S : new String[] {"A", "BB","CCC","DDDD"}){
             list.addFirst(S);
         }
         System.out.println(list);

//         list.addLast("ZZZZ");
//         System.out.println(list);
////        ((SingleLList<Integer>) list).search(0);
//        list.removeFirst();
//        System.out.println(list);

    }




}
