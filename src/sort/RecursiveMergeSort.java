package sort;

/**
 * Created by Deepankit on 9/1/2016.
 */
public class RecursiveMergeSort {

    public static void main(String[] args) {
        RecursiveMergeSort recursiveMergeSort = new RecursiveMergeSort();
        recursiveMergeSort.sortInput(new int[]{10, 8, 5, 6, 4, 80, 90});
    }

    private void sortInput(int[] input) {
        mergeSort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++)
            System.out.println(input[i]);
    }

    private void mergeSort(int[] input, int startIndex, int endIndex) {
        if (startIndex == endIndex)
            return;
        if (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            mergeSort(input, startIndex, mid);
            mergeSort(input, mid + 1, endIndex);
            merge(input, startIndex, mid, endIndex);
        }

    }

    private void merge(int[] input, int startIndex, int mid, int endIndex) {

        int leftLength = mid - startIndex + 1;
        int rightLength = endIndex - mid;
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];
        int i, j;
        int index = startIndex;
        for (i = 0; i < leftLength; i++) {
            left[i] = input[startIndex + i];
        }
        for (j = 0; j < rightLength; j++) {
            right[j] = input[mid + j + 1];
        }
        i = 0;
        j = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                input[index] = left[i];
                i++;
                index++;
            } else {
                input[index] = right[j];
                j++;
                index++;
            }
        }

        while (i < leftLength) {
            input[index] = left[i];
            i++;
            index++;
        }

        while (j < rightLength) {
            input[index] = right[j];
            j++;
            index++;
        }
    }
}
