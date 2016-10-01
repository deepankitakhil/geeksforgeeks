package sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Deepankit on 9/17/2016.
 */
public class BucketSort {
    public static void main(String[] args) {

        BucketSort bucketSort = new BucketSort();
        double[] input = new double[]{0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
        bucketSort.sort(input);
    }

    private void sort(double[] input) {
        Queue<Double>[] bucket = new Queue[10];
        int inputIndex = 0;
        for (int index = 0; index < input.length; index++) {
            int bucketIndex = findBucketIndex(input[index]);
            if (bucket[bucketIndex] == null) {
                bucket[bucketIndex] = new PriorityQueue<>();
            }
            Queue queue = bucket[bucketIndex];
            queue.add(input[index]);
            bucket[bucketIndex] = queue;
        }

        for (int index = 0; index < bucket.length; index++) {
            Queue<Double> queue = bucket[index];
            if (queue != null) {
                while (!queue.isEmpty()) {
                    input[inputIndex] = queue.poll();
                    inputIndex++;
                }
            }
        }
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private int findBucketIndex(double element) {
        while (element < 1) {
            element = element * 10;
        }
        return (int) element;

    }
}
