package sort;

/**
 * Created by Deepankit on 9/15/2016.
 */
public class RecursiveQuickSort {

    public static void main(String[] args) {
        RecursiveQuickSort recursiveQuickSort = new RecursiveQuickSort();
        int[] input = {13, 2, 34, 5, 78, 87, 89, 0, 12};
        int startIndex = 0;
        int endIndex = input.length - 1;
        recursiveQuickSort.sort(input, startIndex, endIndex);
        recursiveQuickSort.printArray(input);
    }

    private void printArray(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void sort(int[] input, int startIndex, int pivotIndex) {
        if (startIndex < pivotIndex) {
            int partition = partition(input, startIndex, pivotIndex);
            sort(input, startIndex, partition - 1);
            sort(input, partition + 1, pivotIndex);
        }
    }

    private int partition(int[] input, int startIndex, int pivotIndex) {
        int start = startIndex - 1;
        int temp = 0;
        int index = startIndex;
        while (index < pivotIndex) {
            if (input[index] > input[pivotIndex]) {
                index++;
            } else {
                start++;
                temp = input[index];
                input[index] = input[start];
                input[start] = temp;
                index++;
            }
        }
        temp = input[start + 1];
        input[start + 1] = input[pivotIndex];
        input[pivotIndex] = temp;
        return start + 1;
    }
}
