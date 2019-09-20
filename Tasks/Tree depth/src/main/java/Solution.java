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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static int getDepth(String secondLine) {
        String[] strings = secondLine.split(" ");
        Map<Integer, List<String>> allChildren = getAllChildren(strings);
        String root = getRoot(strings);
        return getMaxDepth(root, allChildren);
    }

    private static Map<Integer, List<String>> getAllChildren(String[] strings) {
        Map<Integer, List<String>> allChildren = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String parent = strings[i];
            String child = String.valueOf(i);
            List<String> stringList = allChildren.computeIfAbsent(Integer.parseInt(parent), k -> new ArrayList<>());
            stringList.add(child);
        }
        return allChildren;
    }

    private static int getMaxDepth(String root, Map<Integer, List<String>> allChildren) {
        int depth = 1;
        List<String> children = allChildren.get(Integer.parseInt(root));
        if (children != null){
            for (String child : children) {
                depth = Math.max(depth, 1 + getMaxDepth(child, allChildren));
            }
        }
        return depth;
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
