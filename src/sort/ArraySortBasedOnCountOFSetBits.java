package sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Deepankit on 9/17/2016.
 */
public class ArraySortBasedOnCountOFSetBits {
    public static void main(String[] args) {
        ArraySortBasedOnCountOFSetBits arraySortBasedOnCountOFSetBits = new ArraySortBasedOnCountOFSetBits();
        int[] input = new int[]{5, 2, 3, 9, 4, 6, 7, 15, 32};
        arraySortBasedOnCountOFSetBits.sort(input);
        arraySortBasedOnCountOFSetBits.display(input);
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }


    private void sort(int[] input) {
        int largestElement = findLargestElementInAnInput(input);
        int bitsRequiredToPresentAnInput = calculateNumberOfBitsRequiredToPresentAnInput(largestElement);
        Queue[] bucket = new Queue[bitsRequiredToPresentAnInput + 1];
        int outputIndex = 0;
        for (int index = 0; index < input.length; index++) {
            int numberOfBitsRequiredToPresentAnInput = calculateNumberOfBitsWithValueOneInAnInput(input[index]);
            Queue<Integer> queue = bucket[numberOfBitsRequiredToPresentAnInput];
            if (queue == null)
                queue = new LinkedList<>();
            queue.add(input[index]);
            bucket[numberOfBitsRequiredToPresentAnInput] = queue;
        }

        for (int index = bucket.length - 1; index >= 0; index--) {
            Queue<Integer> queue = bucket[index];
            if (queue != null) {
                while (!queue.isEmpty()) {
                    input[outputIndex] = queue.poll();
                    outputIndex++;
                }
            }
        }
    }

    private int calculateNumberOfBitsWithValueOneInAnInput(int element) {
        int count = 0;
        while (element > 0) {
            if (element % 2 == 1)
                count++;
            element /= 2;
        }
        return count;
    }


    private int calculateNumberOfBitsRequiredToPresentAnInput(int largestElement) {
        int bitCount = 0;
        while (largestElement > 0) {
            largestElement = largestElement >> 1;
            bitCount++;
        }
        return bitCount;
    }

    private int findLargestElementInAnInput(int[] input) {
        int maxElement = Integer.MIN_VALUE;
        for (int index = 0; index < input.length; index++)
            if (maxElement <= input[index])
                maxElement = input[index];
        return maxElement;
    }
}
