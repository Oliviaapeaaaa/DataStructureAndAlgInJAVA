package dequeue;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Infix2Postfix {
// operands are assumed to be unsigned non-negative integers.

    private static int prec(String op) {
        switch (op) {
            case "-":
                return 0;
            case "+":
                return 0;
            case "/":
                return 1;
            case "*":
                return 1;
            default:
                throw new UnsupportedOperationException("prec: " + op);
        }
    }

    // transform the output from queue to String
    public static String transformed(Queue<String> output) {
        String value = "";
        for (String piece : output) {
            value += piece + " ";
        }
        return value;
    }


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("arithmetic expression: ");
        // Advances this scanner past the current line and returns the input that was skipped.
        // This method returns the rest of the current line, excluding any line separator at the end. The position is set to the beginning of the next line.
        //Since this method continues to search through the input looking for a line separator, it may buffer all of the input searching for the line to skip if no line separators are present.
        String expression = keyboard.nextLine();
        String token_pattern = "[0-9]+|[-+*/()]";

        Pattern pattern = Pattern.compile(token_pattern);
        Matcher matcher = pattern.matcher(expression);


        Queue<String> output = new ArrayDeque<>() {
        };
        Deque<String> stack = new ArrayDeque<>(

        );

        System.out.println();
        System.out.printf("%-10s%-20s%s\n", "token", "stack", "output");
        System.out.printf("%-10s%-20s%s\n", "-----", "-----", "------");

        while (matcher.find()) {
            String token = matcher.group();
            if (token.matches("[0-9]+")) {
                // operands go directly to output
                output.add(token);
            } else if (token.equals("(")) {
                // left parens are always pushed
                stack.push(token);
            } else if (token.equals(")")) {
                // right parens cause all tokens on stack to be transferred
                // to output, up the the matching (first) left paren
                while (!stack.element().equals("(")) {
                    output.add(stack.pop());
                }
                // finally, pop the starting left paren
                stack.pop();
            } else if (token.matches("[-+*/]")) {
                // token is an operator
                while (!stack.isEmpty()                          // stack not empty
                        && stack.element().matches("[-+*/]")      // an operator is on top
                        && prec(stack.element()) >= prec(token)) {// with >= precedence
                    output.add(stack.pop());  // transfer to output
                }
                stack.push(token); // push token
            }
            System.out.printf("%-10s%-20s%s\n", token, stack, transformed(output));
        }
        // when all tokens processed, transfer remaining (operator) tokens
        // to output
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }
        System.out.printf("%-10s%-20s%s\n", "", stack, transformed(output));


    }
}




