package search;

/**
 * Created by Deepankit on 9/16/2016.
 */
public class NumberOfOccurrenceInASortedArray {
    public static void main(String[] args) {
        NumberOfOccurrenceInASortedArray numberOfOccurrenceInASortedArray = new NumberOfOccurrenceInASortedArray();
        int key = 4;
        int[] input = new int[]{1, 1, 2, 2, 2, 2, 3};
        System.out.println(numberOfOccurrenceInASortedArray.findOccurrence(input, key));
    }

    private int findOccurrence(int[] input, int key) {
        if (input.length > 0) {
            int leftMostKeyIndex = findLeftMostKeyIndex(input, -1, input.length - 1, key);
            int rightMostKeyIndex = findRightMostKeyIndex(input, 0, input.length, key);
            if (input[leftMostKeyIndex] == key && key == input[rightMostKeyIndex])
                return (rightMostKeyIndex - leftMostKeyIndex + 1);
        }

        return Integer.MIN_VALUE;
    }

    private int findLeftMostKeyIndex(int[] input, int startIndex, int endIndex, int key) {
        if (startIndex < endIndex) {
            int midIndex;
            midIndex = startIndex + (endIndex - startIndex) / 2;
            if (midIndex == startIndex) {
                return endIndex;
            } else if (input[midIndex] >= key)
                return findLeftMostKeyIndex(input, startIndex, midIndex, key);
            else
                return findLeftMostKeyIndex(input, midIndex + 1, endIndex, key);
        }
        return Integer.MIN_VALUE;
    }

    private int findRightMostKeyIndex(int[] input, int startIndex, int endIndex, int key) {
        if (startIndex <= endIndex) {
            int midIndex;
            midIndex = startIndex + (endIndex - startIndex) / 2;
            if (midIndex == startIndex) {
                return startIndex;
            } else if (input[midIndex] <= key)
                return findRightMostKeyIndex(input, midIndex, endIndex, key);
            else
                return findRightMostKeyIndex(input, startIndex, midIndex - 1, key);
        }
        return Integer.MIN_VALUE;
    }
}
