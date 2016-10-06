package arrays;

/**
 * Created by Deepankit on 10/3/2016.
 */
public class SortNearlySortedArray {
    public static void main(String[] args) throws Exception {
        SortNearlySortedArray sortNearlySortedArray = new SortNearlySortedArray();
        int[] input = new int[]{3, 1, 2, 5, 4, 7, 6};
        int sortingIndex = 3;
        sortNearlySortedArray.validateInput(input, sortingIndex);
        sortNearlySortedArray.sort(input, sortingIndex);
        sortNearlySortedArray.display(input);
    }

    private void validateInput(int[] input, int sortingIndex) throws Exception {
        if (sortingIndex == input.length)
            throw new ArrayIndexOutOfBoundsException("sortingIndex can't be equal to array length. Please provide value less than array length");
        if (input.length == 0)
            throw new Exception("array can't be empty");
    }

    private void sort(int[] input, int sortingIndex) {
        int endIndex = input.length - sortingIndex - 1;
        int[] minHeap = createMinHeap(input, 0, sortingIndex);
        for (int index = 0; index < endIndex; index++) {
            assignMinHeapFirstElementToItsPosition(input, minHeap, index, sortingIndex);
        }
        sortHeapElementsAndAddThemInInput(input, minHeap, endIndex);

    }

    private void sortHeapElementsAndAddThemInInput(int[] input, int[] minHeap, int endIndex) {
        minHeapify(minHeap);
        int temp;
        for (int index = minHeap.length - 1; index >= 0; index--) {
            temp = minHeap[0];
            minHeap[0] = minHeap[index];
            minHeap[index] = temp;
            minHeapify(minHeap, 0, index);
        }

        for (int index = 0; index < minHeap.length; index++) {
            input[endIndex + index] = minHeap[index];
        }

        for (int index = 0; index < minHeap.length; index++)
            input[endIndex + index] = minHeap[minHeap.length - 1 - index];
    }

    private void assignMinHeapFirstElementToItsPosition(int[] input, int[] minHeap, int index, int sortingIndex) {
        minHeapify(minHeap);
        int minValue = minHeap[0];
        minHeap[0] = input[index + sortingIndex + 1];
        input[index] = minValue;
    }

    private void minHeapify(int[] minHeap) {
        int heapLength = minHeap.length;
        for (int index = heapLength / 2 - 1; index >= 0; index--) {
            minHeapify(minHeap, index, heapLength);
        }
    }

    private void minHeapify(int[] minHeap, int startIndex, int endIndex) {
        int leftChildIndex = 2 * startIndex + 1;
        int rightChildIndex = 2 * startIndex + 2;
        int smallNumberIndex = startIndex;
        if (leftChildIndex < endIndex && minHeap[leftChildIndex] < minHeap[startIndex])
            smallNumberIndex = leftChildIndex;
        if (rightChildIndex < endIndex && minHeap[rightChildIndex] < minHeap[smallNumberIndex])
            smallNumberIndex = rightChildIndex;
        if (smallNumberIndex != startIndex && smallNumberIndex < endIndex) {
            swap(minHeap, minHeap, smallNumberIndex, startIndex);
            minHeapify(minHeap, smallNumberIndex, endIndex);
        }
    }

    private void swap(int[] arrayElementOne, int[] arrayElementTwo, int smallNumberIndex, int endIndex) {
        if (smallNumberIndex != endIndex) {
            arrayElementOne[smallNumberIndex] = arrayElementOne[smallNumberIndex] ^ arrayElementTwo[endIndex];
            arrayElementTwo[endIndex] = arrayElementOne[smallNumberIndex] ^ arrayElementTwo[endIndex];
            arrayElementOne[smallNumberIndex] = arrayElementOne[smallNumberIndex] ^ arrayElementTwo[endIndex];
        }
    }

    private int[] createMinHeap(int[] input, int index, int sortingIndex) {
        int[] heap = new int[sortingIndex + 1];
        loadElementsInHeap(heap, input, index);
        return heap;
    }

    private void loadElementsInHeap(int[] heap, int[] input, int startIndex) {
        for (int index = 0; index < heap.length; index++)
            heap[index] = input[index + startIndex];
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++) {
            System.out.println(input[index]);
        }
    }
}
