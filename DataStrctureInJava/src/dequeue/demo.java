package dequeue;

import java.util.Deque;
import java.util.Queue;

public class demo {
    public static void main(String[] args) {
        Deque<String> stack = new ADeque<>();
//        Queue<String> queue = new ADeque<>();
        Deque<Integer> deque = new ADeque<>();
        for (int i = 1; i <= 11; ++i) {
            deque.push(i);
            deque.add(i * 2);
            System.out.println(deque);
            System.out.println( "--> info:\n" + ((ADeque<Integer>) deque).info() + "\n" );
        }
        System.out.println(deque);
        System.out.println( "--> info:\n" + ((ADeque<Integer>) deque).info() + "\n" );

        for(String str : new String[]{"aaa", "bbb", "ccc", "ddd"}){
            stack.addLast(str);
            System.out.println(stack);
            System.out.println("--> info:\n" + ((ADeque<String>) stack).info() + "\n");
        }
        System.out.println(stack);
        System.out.println("--> info:\n" + ((ADeque<String>) stack).info() + "\n");
        stack.pop();
        System.out.println(stack);

    }
}
