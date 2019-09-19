import java.util.*;

/*
        Input : n numbers, m - window length
            go through numbers using m window
        Output: minimum for each window

        Example: 1 - 2 - 4 - 8 - 9
                Window: 3 (first window 1 - 2 - 4; second 2 - 4 - 8 etc.)
                Output: 1 - 2 - 4
 */
public class Solution {
    /**
     * First solution with foreach and sorting
     *
     * @param n numbers
     * @param m window length
     * @return minimums
     */
    public static int[] getWindowsSimple(int[] n, int m){
        List<Integer> result = new ArrayList<>();
        if (m == 1 || n.length == 1){
            return n;
        }
        int windowsCount = n.length - m + 1;
        int windowTo = m - 1;
        for (int i = 0; i < windowsCount; i++, windowTo++) {
            int[] window = Arrays.copyOfRange(n, i, windowTo + 1);
            Arrays.sort(window);
            result.add(window[0]);
        }
        return result.stream().mapToInt(i->i).toArray();
    }


    /**
     * Second solution with queue
     *
     * @param n numbers
     * @param m window length
     * @return minimums
     */
    public static int[] getWindowsQueque(int[] n, int m){
        List<Integer> result = new ArrayList<>();

        if (m == 1 || n.length == 1){
            return n;
        }

        Queue<Integer> windowQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            windowQueue.add(n[i]);
        }
        int currentMinimum = Collections.min(windowQueue);
        result.add(currentMinimum);

        for (int i = m; i < n.length; i++) {
            windowQueue.add(n[i]);
            if (n[i] <= currentMinimum){
                currentMinimum = n[i];
                result.add(currentMinimum);
                windowQueue.poll();
                continue;
            }
            if (windowQueue.poll().equals(currentMinimum)){
                currentMinimum = Collections.min(windowQueue);
            }
            result.add(currentMinimum);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
