package sort;

/**
 * Created by Deepankit on 9/1/2016.
 */
public class IterativeMergeSort {

    public static void main(String[] args) {
        IterativeMergeSort iterativeMergeSort = new IterativeMergeSort();
        iterativeMergeSort.sortInput(new int[]{10, 8, 5, 6, 4, 80, 1});
    }

    private void sortInput(int[] input) {
        mergeSort(input, input.length - 1);
        for (int i = 0; i < input.length; i++)
            System.out.println(input[i]);
    }

    private void mergeSort(int[] input, int endIndex) {
        int mid;
        int end;
        for (int i = 1; i < endIndex; i = i * 2) {
            for (int j = 0; j < endIndex; j = j + 2 * i) {
                mid = i + j - 1;
                end = (mid + i) < endIndex ? (mid + i) : endIndex;
                merge(input, j, mid, end);
            }
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
