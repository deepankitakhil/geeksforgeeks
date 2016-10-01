package sort;

/**
 * Created by Deepankit on 9/7/2016.
 */
public class InversionCountByIterativeMergeSort {

    public static void main(String[] args) {
        InversionCountByIterativeMergeSort inversionCountByRecursiveMergeSort = new InversionCountByIterativeMergeSort();
        System.out.println(inversionCountByRecursiveMergeSort.sort(new int[]{2, 7, 5, 0, 8, 1}));
    }

    private int sort(int[] input) {
        if (input.length > 0)
            return mergeSort(input, input.length - 1);
        return Integer.MIN_VALUE;
    }

    private int mergeSort(int[] input, int endIndex) {
        int inversionCount = 0;
        for (int i = 1; i <= endIndex; i = i * 2)
            for (int j = 0; j < endIndex; j = j + 2 * i) {
                int midIndex = i + j - 1;
                int end = (midIndex + i) > endIndex ? endIndex : (midIndex + i);
                inversionCount += merge(input, j, midIndex, end);
            }
        return inversionCount;
    }

    private int merge(int[] input, int startIndex, int midIndex, int endIndex) {
        int leftArrayLength = midIndex - startIndex + 1;
        int rightArrayLength = endIndex - midIndex;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int inputIndex = startIndex;
        int inversionCount = 0;
        while (leftArrayIndex < leftArrayLength) {
            leftArray[leftArrayIndex] = input[inputIndex + leftArrayIndex];
            leftArrayIndex++;
        }
        while (rightArrayIndex < rightArrayLength) {
            rightArray[rightArrayIndex] = input[midIndex + rightArrayIndex + 1];
            rightArrayIndex++;
        }
        leftArrayIndex = 0;
        rightArrayIndex = 0;

        while (leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
            if (leftArray[leftArrayIndex] > rightArray[rightArrayIndex]) {
                input[inputIndex++] = leftArray[leftArrayIndex++];
            } else {
                input[inputIndex++] = rightArray[rightArrayIndex++];
                inversionCount = inversionCount + leftArrayLength - leftArrayIndex;
            }
        }

        while (leftArrayIndex < leftArrayLength)
            input[inputIndex++] = leftArray[leftArrayIndex++];
        while (rightArrayIndex < rightArrayLength)
            input[inputIndex++] = rightArray[rightArrayIndex++];
        return inversionCount;
    }
}
