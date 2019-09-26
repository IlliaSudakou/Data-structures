import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int number = scanner.nextInt();
        int queryCount = scanner.nextInt();

        int initMax = 0;
        int[] parent = new int[number];
        int[] rank = new int[number];
        for (int i = 0; i < number; i++) {
            int element = scanner.nextInt();
            if (element > initMax){
                initMax = element;
            }
            rank[i] = element;
            parent[i] = i;
        }

        for (int i = 0; i < queryCount; i++) {
            int value = process(parent, rank, scanner.nextInt() - 1, scanner.nextInt() - 1);
            if (value > initMax){
                initMax = value;
                stringBuilder.append(value).append("\n");
            }
            else {
                stringBuilder.append(initMax).append("\n");
            }
        }
        System.out.println(stringBuilder.toString());

    }

    private static int process(int[] parent, int[] rank, int from, int to) {
        if (parent[from] != parent[to]) {
            if (parent[from] == from){
                if (parent[to] == to){
                    parent[from] = to;
                    rank[to] += rank[from];
                }else {
                    int parentToRank = process(parent, rank, from, parent[to]);
                    // save path to parent
                    parent[to] = parent[from];
                    return parentToRank;
                }
            }
            else {
                int parentFromRank = process(parent, rank, parent[from], to);
                // save path to parent
                parent[from] = parent[to];
                return parentFromRank;
            }
        }
        return rank[to];
    }
}
