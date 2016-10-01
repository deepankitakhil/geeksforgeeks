package sort;

/**
 * Created by Deepankit on 9/15/2016.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] input = new int[]{4, 3, 67, 8, 123, 89, 0, 12};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(input);
        heapSort.display(input);
    }

    private void display(int[] input) {
        for (int i = 0; i < input.length; i++)
            System.out.println(input[i]);
    }

    private void sort(int[] input) {
        int index = input.length;
        int temp;
        for (int i = index / 2 - 1; i >= 0; i--) {
            maxHeapify(input, i, index);
        }
        for (int i = index - 1; i >= 0; i--) {
            temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            maxHeapify(input, 0, i);
        }
    }

    private void maxHeapify(int[] input, int index, int endIndex) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int higherValueArrayIndex = 0;
        int temp = 0;

        if (leftIndex < endIndex && input[leftIndex] <= input[index])
            higherValueArrayIndex = index;
        else
            higherValueArrayIndex = leftIndex;
        if (rightIndex < endIndex && input[higherValueArrayIndex] < input[rightIndex])
            higherValueArrayIndex = rightIndex;

        if (higherValueArrayIndex < endIndex && higherValueArrayIndex != index) {
            temp = input[index];
            input[index] = input[higherValueArrayIndex];
            input[higherValueArrayIndex] = temp;
            maxHeapify(input, higherValueArrayIndex, endIndex);
        }

    }
}
