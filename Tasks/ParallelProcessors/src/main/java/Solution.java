/*
Parallel processors

Input:
n - processors quantity
m - tasks quantity

t0 .... ti - time for each task

Output:
new line for each task
processor number - start time

example
Input
2 5
1 2 3 4 5
Output
0 0
1 0
0 1
1 2
0 4
 */


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        String secondLine = in.nextLine();
        String[] tasks = secondLine.split(" ");
        String[] strings = firstLine.split(" ");
        long[] array = Arrays.stream(tasks).parallel().mapToLong(Long::parseLong).toArray();

        StringBuilder stringBuilder = new StringBuilder();

        process(Integer.parseInt(strings[0]), array, stringBuilder);

        System.out.println(stringBuilder.toString());
    }

    public static void process(int n, long[] tasks, StringBuilder stringBuilder){

        PriorityQueue<ProcessorPair> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(new ProcessorPair(0,i));
        }
        for (long task : tasks) {
            ProcessorPair poll = queue.poll();
            stringBuilder.append(poll.getProcessorIndex()).append(" ").append(poll.getTime()).append("\n");
            poll.setTime(poll.getTime() + task);
            queue.add(poll);
        }

    }

    static class ProcessorPair implements Comparable<ProcessorPair>{
        long time;
        int processorIndex;

        public ProcessorPair(int time, int processorIndex) {
            this.time = time;
            this.processorIndex = processorIndex;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getProcessorIndex() {
            return processorIndex;
        }

        public void setProcessorIndex(int processorIndex) {
            this.processorIndex = processorIndex;
        }

        @Override
        public int compareTo(ProcessorPair o) {
            if (o.getTime() > this.getTime()){
                return -1;
            }else if (o.getTime() < this.getTime()){
                return 1;
            }
            if (o.getTime() == this.getTime() && o.getProcessorIndex() > this.processorIndex){
                return -1;
            }else if (o.getTime() == this.getTime() && o.getProcessorIndex() < this.processorIndex){
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "ProcessorPair{" +
                    "time=" + time +
                    ", processorIndex=" + processorIndex +
                    '}';
        }
    }
}
