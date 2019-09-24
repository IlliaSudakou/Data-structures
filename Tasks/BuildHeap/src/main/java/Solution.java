import java.util.*;

/**
 * Build a heap using input array
 *
 * Input: first line - number
 *          second line - array
 *
 *  Output: first line - count of swaps
 *            second line - indexes of swapped elements if any
 */
public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String secondLine = in.nextLine();
        String[] strings = secondLine.split(" ");
        int[] array = Arrays.stream(strings).parallel().mapToInt(Integer::parseInt).toArray();
        buildHeap(array);
    }

    public static void buildHeap(int[] a) {
        List<Integer> list = new ArrayList<>(a.length);
        for (int i : a) {
            list.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Heap heap = new Heap(list);

        for (int i = a.length / 2; i >= 0; i--) {
            heap.siftDown(i, stringBuilder);
        }

        System.out.println(heap.getCount());
        System.out.println(stringBuilder.toString());
    }

}

class Heap {
    private List<Integer> heap;
    private int count;

    public Heap(List<Integer> heap) {
        this.heap = heap;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }

    private void siftUp(int i) {
        while (i > 0 && heap.get(getParent(i)) < heap.get(i)) {
            Collections.swap(heap, getParent(i), i);
            i = getParent(i);
        }
    }

    public void siftDown(int i, StringBuilder stringBuilder) {
        int minIndex = i;
        int left = getLeft(i);
        if (left < heap.size() && heap.get(left) < heap.get(minIndex)) {
            minIndex = left;
        }
        int right = getRight(i);
        if (right < heap.size() && heap.get(right) < heap.get(minIndex)) {
            minIndex = right;
        }
        if (i != minIndex) {
            stringBuilder.append(i).append(" ").append(minIndex).append("\n");
            Collections.swap(heap, i, minIndex);
            count++;
            siftDown(minIndex, stringBuilder);
        }
    }
}
