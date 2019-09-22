/*

read n lines with queries

example

input

4
push 2
push 1
pop
max

output
2

 */

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private  static String PUSH = "push";
    private  static String MAX = "max";
    private  static String POP = "pop";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackMax = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int queryCount = scanner.nextInt();
        for (int i = 0; i <= queryCount; i++) {
            String operation = scanner.nextLine();
            doOperations(operation, stack, stackMax, stringBuilder);
        }
        System.out.println(stringBuilder.toString());
    }

    private static void doOperations(String operation, Stack<Integer> stack, Stack<Integer> stackMax, StringBuilder stringBuilder) {
        if (operation.startsWith(PUSH)){
            int value = Integer.parseInt(operation.substring(5));
            stack.push(value);
            if (stackMax.isEmpty() || stackMax.peek() < value){
                stackMax.push(value);
            }
            else {
                stackMax.push(stackMax.peek());
            }
        }
        if (operation.equals(POP)){
            stack.pop();
            stackMax.pop();
        }
        if (operation.equals(MAX) && !stackMax.isEmpty()){
            stringBuilder.append(stackMax.peek());
            stringBuilder.append("\n");
        }
    }
}
