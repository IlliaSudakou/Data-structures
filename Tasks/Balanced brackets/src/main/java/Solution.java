
/*
    Check whether brackets balanced or not

    Example
        Input: ([ text ](){([])})
        Output: Success

        Input: ()[]}
        Output: 5


 */

import java.util.Arrays;
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
        System.out.println(process(args[0]));
        System.out.println(Arrays.toString(args));
    }

    public static String process(String input){
        if (input.length() == 1){
            return "1";
        }
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isOpened(chars[i])){
                stack.push(chars[i]);
                indexes.push(i + 1);
            }
            else if (isClosed(chars[i])){
                if (stack.isEmpty()){
                    return String.valueOf(i + 1);
                }
                Character pop = stack.pop();
                indexes.pop();
                if (!isClosable(pop, chars[i])){
                    return String.valueOf(i + 1);
                }
            }
        }
        if (!indexes.isEmpty()){
            return String.valueOf(indexes.pop());
        }
        return success;
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
