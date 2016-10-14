package sort;

/**
 * Created by Deepankit on 10/12/2016.
 */
public class SortAnArrayInWaveFormUsingRecursiveMergeSort {
    public static void main(String[] args) throws Exception {
        SortAnArrayInWaveFormUsingRecursiveMergeSort sortAnArrayInWaveFormUsingRecursiveMergeSort = new SortAnArrayInWaveFormUsingRecursiveMergeSort();
        int[] input = new int[]{10, 5, 6, 3, 2, 20, 100, 80};
        sortAnArrayInWaveFormUsingRecursiveMergeSort.validate(input);
        sortAnArrayInWaveFormUsingRecursiveMergeSort.sortElements(input);
        sortAnArrayInWaveFormUsingRecursiveMergeSort.arrangeInWaveForm(input);
        sortAnArrayInWaveFormUsingRecursiveMergeSort.print(input);
    }

    private void print(int[] input) {
        int endIndex = input.length - 1;
        for (int index = 0; index <= endIndex; index++)
            System.out.println(input[index]);
    }

    private void arrangeInWaveForm(int[] input) {
        int endIndex = input.length - 1;
        for (int index = 0; index <= endIndex / 2; index += 2)
            swap(input, index, (endIndex - index));
    }

    private void swap(int[] input, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            input[firstIndex] = input[firstIndex] ^ input[secondIndex];
            input[secondIndex] = input[firstIndex] ^ input[secondIndex];
            input[firstIndex] = input[firstIndex] ^ input[secondIndex];
        }
    }

    private void sortElements(int[] input) {
        mergeSort(input, 0, input.length - 1);
    }

    private void mergeSort(int[] input, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            mergeSort(input, startIndex, midIndex);
            mergeSort(input, midIndex + 1, endIndex);
            merge(input, startIndex, midIndex, endIndex);
        }
    }

    private void merge(int[] input, int startIndex, int midIndex, int endIndex) {
        int leftArrayLength = midIndex - startIndex + 1;
        int rightArrayLength = endIndex - midIndex;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        int leftIndex;
        int rightIndex;
        int inputIndex = startIndex;
        for (leftIndex = 0; leftIndex < leftArrayLength; leftIndex++)
            leftArray[leftIndex] = input[startIndex + leftIndex];

        for (rightIndex = 0; rightIndex < rightArrayLength; rightIndex++)
            rightArray[rightIndex] = input[midIndex + 1 + rightIndex];

        leftIndex = 0;
        rightIndex = 0;

        while (leftIndex < leftArrayLength && rightIndex < rightArrayLength) {
            if (leftArray[leftIndex] < rightArray[rightIndex])
                input[inputIndex++] = leftArray[leftIndex++];
            else {
                input[inputIndex++] = rightArray[rightIndex++];
            }
        }

        while (leftIndex < leftArrayLength)
            input[inputIndex++] = leftArray[leftIndex++];
        while (rightIndex < rightArrayLength)
            input[inputIndex++] = rightArray[rightIndex++];

    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }
}
