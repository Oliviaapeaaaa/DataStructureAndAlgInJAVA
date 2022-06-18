package dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostfixEvaluate {
    private static Integer doOperation(
            String operator, Integer first, Integer second) {
        switch(operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                throw new UnsupportedOperationException("doOperation: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("postfix expression: ");
        String expression = keyboard.nextLine();

        String token_pattern = "[0-9]+|[+*-/]";

        Pattern pattern = Pattern.compile(token_pattern);
        Matcher matcher = pattern.matcher(expression);

        Deque<Integer> stack = new ArrayDeque<>();

        System.out.printf("%-10s%s\n", "token", "stack");
        System.out.printf("%-10s%s\n", "-----", "-----");
        while (matcher.find()) {
            String token = matcher.group();
            if (token.matches("[0-9]+")) {
                // operands are pushed
                stack.push(Integer.parseInt(token));
            }
            else {
                // operators take top 2 stack operands (in reverse order)
                // compute the new value with operator and push on stack
                Integer second = stack.pop();
                Integer first = stack.pop();
                Integer value = doOperation(token, first, second);
                stack.push(value);
            }
            System.out.printf("%-10s%s\n", token, stack);
        }
    }


}
