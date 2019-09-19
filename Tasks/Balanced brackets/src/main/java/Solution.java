
/*
    Check whether brackets balanced or not

    Example
        Input: ([ text ](){([])})
        Output: Success

        Input: ()[]}
        Output: 5


 */

import java.util.Stack;

public class Solution {
    private static String success = "Success";

    private static char openedA = '[';
    private static char openedB = '{';
    private static char openedC = '(';

    private static char closedA = ']';
    private static char closedB = '}';
    private static char closedC = ')';

    public static void main(String[] args) {
        process(args[0]);
    }

    public static void process(String input){
        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isOpened(chars[i])){
                stack.push(chars[i]);
            }
            else if (isClosed(chars[i])){
                Character pop = stack.pop();
                if (!isClosable(pop, chars[i])){
                    System.out.println( i + 1);
                    return;
                }
            }
        }
        System.out.println(success);;
    }

    private static boolean isClosable(Character pop, char c) {
        if (pop == openedA && c == closedA){
            return true;
        }
        if (pop == openedB && c == closedB){
            return true;
        }
        if (pop == openedC && c == closedC){
            return true;
        }
        return false;
    }

    private static boolean isClosed(char c) {
        if (c == closedA || c == closedB || c == closedC){
            return true;
        }
        return false;
    }

    private static boolean isOpened(char c) {
        if (c == openedA || c == openedB || c == openedC){
            return true;
        }
        return false;
    }
}
