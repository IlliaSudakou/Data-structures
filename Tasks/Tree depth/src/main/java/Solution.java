/*
Find tree depth

Input tree:

4 -1 4 1 1

     1
    / \
   3   4
      / \
     0   2

Output - 3
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int getDepth(String secondLine) {
        String[] strings = secondLine.split(" ");
        String root = getRoot(strings);
        return getMaxDepth(strings, root);
    }

    private static int getMaxDepth(String[] strings, String root) {
        int depth = 1;

        String[] children = getChildren(root, strings);
        if (children.length > 0){
            for (String child : children) {
                depth = max(depth, 1+ getMaxDepth(strings, child));
            }
        }

        return depth;
    }

    private static int max(int depth, int i) {
        return Math.max(depth, i);
    }

    private static String[] getChildren(String root, String[] strings) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (root.equals(strings[i])) {
                list.add(String.valueOf(i));
            }
        }
        return list.toArray(new String[0]);
    }

    private static String getRoot(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if ("-1".equals(strings[i])){
                return String.valueOf(i);
            }
        }
        return "0";
    }
}
