package sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Deepankit on 9/16/2016.
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] input = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(input);
    }

    private void sort(int[] input) {
        int maxElement = findMaxElement(input);
        int maxSignificantBit = findMaxSignificantBit(maxElement);
        Queue<Integer>[] bucket = new Queue[10];
        radixSort(input, maxSignificantBit, bucket);
    }

    private void radixSort(int[] input, int maxSignificantBit, Queue<Integer>[] bucket) {
        int output[] = new int[input.length];
        int outputIndex;
        Queue<Integer> queue;
        for (int bitCount = 1; bitCount <= maxSignificantBit; bitCount++) {
            outputIndex = 0;
            for (int index = 0; index < input.length; index++) {
                int bucketId = getBucketId(input[index], bitCount);
                if (bucket[bucketId] == null) {
                    bucket[bucketId] = new LinkedList<>();
                }
                queue = bucket[bucketId];
                queue.add(input[index]);
                bucket[bucketId] = queue;
            }

            for (int index = 0; index < bucket.length; index++) {
                queue = bucket[index];
                while (queue != null && !queue.isEmpty()) {
                    output[outputIndex] = queue.poll();
                    outputIndex++;
                }
            }
            input = output;
        }

        for (int index = 0; index < output.length; index++)
            System.out.println(output[index]);
    }

    private int getBucketId(int input, int significantBitIndex) {
        int digit = 0;
        int bitCount = 0;
        while (bitCount != significantBitIndex) {
            digit = input % 10;
            input /= 10;
            bitCount++;
        }
        return digit;
    }

    private int findMaxSignificantBit(int maxElement) {
        int bitCount = 0;
        while (maxElement > 0) {
            maxElement = maxElement / 10;
            bitCount++;
        }
        return bitCount;
    }

    private int findMaxElement(int[] input) {
        int maxElement = Integer.MIN_VALUE;
        for (int index = 0; index < input.length; index++) {
            if (maxElement <= input[index])
                maxElement = input[index];
        }
        return maxElement;
    }
}
