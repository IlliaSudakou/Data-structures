import java.util.*;

/*
        Input : n numbers, m - window length
            go through numbers using m window
        Output: maximum / minimum for each window

        Example: 1 - 2 - 4 - 8 - 9
                Window: 3 (first window 1 - 2 - 4; second 2 - 4 - 8 etc.)
                Output: 1 - 2 - 4
 */
public class Solution {

    /**
     * Second solution with queue
     *
     * @param n numbers
     * @param m window length
     * @return minimums
     */
    public static int[] getWindowsQuequeMin(int[] n, int m){
        List<Integer> result = new ArrayList<>();
        if (m == 1 || n.length == 1){
            return n;
        }
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        Stack<Integer> leftStackMin = new Stack<>();
        Stack<Integer> rightStackMin = new Stack<>();

        for (int i = 0; i < m; i++) {
            populateStackMin(leftStack, leftStackMin, n[i]);
        }
        populateRightStackMin(result, leftStack, rightStack, rightStackMin, leftStackMin);

        for (int i = m; i < n.length; i++) {
            populateStackMin(leftStack, leftStackMin, n[i]);
            if (!rightStack.isEmpty()){
                rightStack.pop();
                rightStackMin.pop();
                if (rightStack.isEmpty()){
                    populateRightStackMin(result, leftStack, rightStack, rightStackMin, leftStackMin);
                }
                else {
                    if (leftStackMin.peek() < rightStackMin.peek()){
                        result.add(leftStackMin.peek());
                    }
                    else {
                        result.add(rightStackMin.peek());
                    }
                }
            }
            else {
                populateRightStackMin(result, leftStack, rightStack, rightStackMin, leftStackMin);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }


    public static int[] getWindowsQuequeMaximum(int[] n, int m){
        List<Integer> result = new ArrayList<>();
        if (m == 1 || n.length == 1){
            return n;
        }
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        Stack<Integer> leftStackMax = new Stack<>();
        Stack<Integer> rightStackMax = new Stack<>();

        for (int i = 0; i < m; i++) {
            populateStackMax(leftStack, leftStackMax, n[i]);
        }
        populateRightStack(result, leftStack, rightStack, rightStackMax, leftStackMax);

        for (int i = m; i < n.length; i++) {
            populateStackMax(leftStack, leftStackMax, n[i]);
            if (!rightStack.isEmpty()){
                rightStack.pop();
                rightStackMax.pop();
                if (rightStack.isEmpty()){
                    populateRightStack(result, leftStack, rightStack, rightStackMax, leftStackMax);
                }
                else {
                    if (leftStackMax.peek() > rightStackMax.peek()){
                        result.add(leftStackMax.peek());
                    }
                    else {
                        result.add(rightStackMax.peek());
                    }
                }
            }
            else {
                populateRightStack(result, leftStack, rightStack, rightStackMax, leftStackMax);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    private static void populateStackMax(Stack<Integer> leftStack, Stack<Integer> leftStackMax, int currentValue) {
        leftStack.push(currentValue);
        if (leftStackMax.isEmpty() || leftStackMax.peek() < currentValue) {
            leftStackMax.push(currentValue);
        } else {
            leftStackMax.push(leftStackMax.peek());
        }
    }

    private static void populateRightStack(List<Integer> result, Stack<Integer> leftStack,
                                           Stack<Integer> rightStack, Stack<Integer> rightStackMax, Stack<Integer> leftStackMax) {
        while (!leftStack.isEmpty()) {
            Integer item = leftStack.pop();
            leftStackMax.pop();
            populateStackMax(rightStack, rightStackMax, item);
        }
        result.add(rightStackMax.peek());
    }

    private static void populateStackMin(Stack<Integer> leftStack, Stack<Integer> leftStackMin, int currentValue) {
        leftStack.push(currentValue);
        if (leftStackMin.isEmpty() || leftStackMin.peek() > currentValue) {
            leftStackMin.push(currentValue);
        } else {
            leftStackMin.push(leftStackMin.peek());
        }
    }

    private static void populateRightStackMin(List<Integer> result, Stack<Integer> leftStack,
                                           Stack<Integer> rightStack, Stack<Integer> rightStackMin, Stack<Integer> leftStackMin) {
        while (!leftStack.isEmpty()) {
            Integer item = leftStack.pop();
            leftStackMin.pop();
            populateStackMin(rightStack, rightStackMin, item);
        }
        result.add(rightStackMin.peek());
    }
}
