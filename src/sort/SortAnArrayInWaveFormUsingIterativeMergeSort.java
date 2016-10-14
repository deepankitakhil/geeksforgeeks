package sort;

/**
 * Created by Deepankit on 10/12/2016.
 */
public class SortAnArrayInWaveFormUsingIterativeMergeSort {
    public static void main(String[] args) throws Exception {
        SortAnArrayInWaveFormUsingIterativeMergeSort sortAnArrayInWaveFormUsingIterativeMergeSort = new SortAnArrayInWaveFormUsingIterativeMergeSort();
        int[] input = new int[]{10, 5, 6, 3, 2, 20, 100, 80};
        sortAnArrayInWaveFormUsingIterativeMergeSort.validate(input);
        sortAnArrayInWaveFormUsingIterativeMergeSort.sort(input);
        sortAnArrayInWaveFormUsingIterativeMergeSort.arrangeInWaveForm(input);
        sortAnArrayInWaveFormUsingIterativeMergeSort.print(input);
    }

    private void print(int[] input) {
        int endIndex = input.length - 1;
        for (int index = 0; index <= endIndex; index++)
            System.out.println(input[index]);
    }

    private void arrangeInWaveForm(int[] input) {
        for (int index = 0; index < input.length / 2; index = index + 2)
            swap(input, index, input.length - 1 - index);
    }

    private void swap(int[] input, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            input[firstIndex] = input[firstIndex] ^ input[secondIndex];
            input[secondIndex] = input[firstIndex] ^ input[secondIndex];
            input[firstIndex] = input[firstIndex] ^ input[secondIndex];
        }
    }

    private void sort(int[] input) {
        int midIndex;
        int end;
        int endIndex = input.length - 1;
        for (int firstIndex = 1; firstIndex < endIndex; firstIndex = firstIndex * 2) {
            for (int secondIndex = 0; secondIndex < endIndex; secondIndex = secondIndex + 2 * firstIndex) {
                midIndex = secondIndex + firstIndex - 1;
                end = (midIndex + firstIndex) > endIndex ? endIndex : (midIndex + firstIndex);
                merge(input, secondIndex, midIndex, end);
            }
        }
    }

    private void merge(int[] input, int startIndex, int midIndex, int endIndex) {
        int leftArrayLength = midIndex - startIndex + 1;
        int rightArrayLength = endIndex - midIndex;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        int leftArrayIndex;
        int rightArrayIndex;
        int inputArrayIndex = startIndex;

        for (leftArrayIndex = 0; leftArrayIndex < leftArrayLength; leftArrayIndex++)
            leftArray[leftArrayIndex] = input[startIndex + leftArrayIndex];

        for (rightArrayIndex = 0; rightArrayIndex < rightArrayLength; rightArrayIndex++)
            rightArray[rightArrayIndex] = input[midIndex + 1 + rightArrayIndex];

        leftArrayIndex = 0;
        rightArrayIndex = 0;

        while (leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
            if (leftArray[leftArrayIndex] < rightArray[rightArrayIndex])
                input[inputArrayIndex++] = leftArray[leftArrayIndex++];
            else
                input[inputArrayIndex++] = rightArray[rightArrayIndex++];
        }

        while (leftArrayIndex < leftArrayLength)
            input[inputArrayIndex++] = leftArray[leftArrayIndex++];

        while (rightArrayIndex < rightArrayLength)
            input[inputArrayIndex++] = rightArray[rightArrayIndex++];

    }


    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }
}
