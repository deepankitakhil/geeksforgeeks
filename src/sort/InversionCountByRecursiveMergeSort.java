package sort;

/**
 * Created by Deepankit on 9/7/2016.
 */
public class InversionCountByRecursiveMergeSort {

    public static void main(String[] args) {
        InversionCountByRecursiveMergeSort inversionCountByRecursiveMergeSort = new InversionCountByRecursiveMergeSort();
        System.out.println(inversionCountByRecursiveMergeSort.sort(new int[]{2, 7, 5, 0, 8, 1}));
    }

    private int sort(int[] input) {
        if (input.length > 0)
            return mergeSort(input, 0, input.length - 1);
        return Integer.MIN_VALUE;
    }

    private int mergeSort(int[] input, int startIndex, int endIndex) {
        int mid;

        int inversionCount = 0;
        if (startIndex == endIndex)
            return inversionCount;
        if (startIndex < endIndex) {
            mid = startIndex + (endIndex - startIndex) / 2;
            inversionCount = mergeSort(input, startIndex, mid);
            inversionCount += mergeSort(input, mid + 1, endIndex);
            inversionCount += merge(input, startIndex, mid, endIndex);
        }

        return inversionCount;
    }

    private int merge(int[] input, int startIndex, int mid, int endIndex) {
        int inversionCount = 0;
        int leftArrayLength = mid - startIndex + 1;
        int rightArrayLength = endIndex - mid;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];
        int inputArrayIndex;

        for (int i = 0; i < leftArrayLength; i++) {
            leftArray[i] = input[i + startIndex];
        }

        for (int j = 0; j < rightArrayLength; j++)
            rightArray[j] = input[mid + j + 1];
        int i = 0;
        int j = 0;
        inputArrayIndex = startIndex;
        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] >= rightArray[j]) {
                input[inputArrayIndex] = leftArray[i];
                i++;
            } else {
                input[inputArrayIndex] = rightArray[j];
                j++;
                inversionCount = inversionCount + leftArrayLength - i;
            }
            inputArrayIndex++;
        }

        while (i < leftArrayLength) {
            input[inputArrayIndex] = leftArray[i];
            i++;
            inputArrayIndex++;
        }
        while (j < rightArrayLength) {
            input[inputArrayIndex] = rightArray[j];
            j++;
            inputArrayIndex++;
        }

        return inversionCount;
    }

}
