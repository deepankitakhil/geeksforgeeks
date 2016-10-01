package sort;

/**
 * Created by Deepankit on 9/18/2016.
 */
public class RearrangePositiveAndNegativeIntegers {

    public static void main(String[] args) {
        RearrangePositiveAndNegativeIntegers rearrangePositiveAndNegativeIntegers = new RearrangePositiveAndNegativeIntegers();
        int[] input = new int[]{12, 11, -13, -5, 6, -7, 5, -3, -6};
        rearrangePositiveAndNegativeIntegers.rearrange(input);
        rearrangePositiveAndNegativeIntegers.display(input);
    }

    private void rearrange(int[] input) {
        modifiedMergeSort(input, 0, input.length - 1);
    }

    private void modifiedMergeSort(int[] input, int startIndex, int endIndex) {
        int midIndex;
        int lastIndex;
        for (int i = 1; i <= endIndex; i = i * 2)
            for (int j = 0; j < endIndex; j = j + 2 * i) {
                midIndex = i + j - 1;
                lastIndex = midIndex + i >= endIndex ? endIndex : midIndex + i;
                modifiedMerge(input, j, midIndex, lastIndex);
            }
    }

    private void modifiedMerge(int[] input, int startIndex, int midIndex, int lastIndex) {
        int leftArrayLength = midIndex - startIndex + 1;
        int rightArrayLength = lastIndex - midIndex;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        int rightIndex;
        int leftIndex;
        int arrayIndex = startIndex;

        for (leftIndex = 0; leftIndex < leftArrayLength; leftIndex++)
            leftArray[leftIndex] = input[arrayIndex + leftIndex];

        for (rightIndex = 0; rightIndex < rightArrayLength; rightIndex++)
            rightArray[rightIndex] = input[midIndex + 1 + rightIndex];

        rightIndex = 0;
        leftIndex = 0;
        while (leftIndex < leftArrayLength && leftArray[leftIndex] < 0)
            input[arrayIndex++] = leftArray[leftIndex++];

        while (rightIndex < rightArrayLength && rightArray[rightIndex] < 0)
            input[arrayIndex++] = rightArray[rightIndex++];

        while (leftIndex < leftArrayLength)
            input[arrayIndex++] = leftArray[leftIndex++];

        while (rightIndex < rightArrayLength)
            input[arrayIndex++] = rightArray[rightIndex++];

    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }
}
