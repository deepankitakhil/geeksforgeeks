package heap;

/**
 * Created by Deepankit on 10/6/2016.
 */
@SuppressWarnings("Duplicates")
public class FindKSmallestElements {
    public static void main(String[] args) {
        FindKSmallestElements findKSmallestElements = new FindKSmallestElements();
        int[] input = new int[]{12, 3, 5, 7, 19};
        int index = 4;
        findKSmallestElements.findKSmallestElementsUsingMinHeap(input, index);
        findKSmallestElements.findKSmallestElementsUsingMaxHeap(input, index);
    }

    private void findKSmallestElementsUsingMinHeap(int[] input, int index) {
        int inputArrayLength = input.length;
        int[] heap = new int[inputArrayLength];
        for (int heapIndex = 0; heapIndex < inputArrayLength; heapIndex++)
            heap[heapIndex] = input[heapIndex];
        buildMinHeap(heap);
        for (int heapIndex = 0; heapIndex < index; heapIndex++) {
            System.out.println(extractMin(heap, heapIndex));
        }
    }

    private void findKSmallestElementsUsingMaxHeap(int[] input, int index) {
        int[] heap = new int[index];
        for (int heapArrayIndex = 0; heapArrayIndex < index; heapArrayIndex++)
            heap[heapArrayIndex] = input[heapArrayIndex];
        buildMaxHeap(heap);
        for (int inputArrayIndex = index; inputArrayIndex < input.length; inputArrayIndex++) {
            if (input[inputArrayIndex] < heap[0]) {
                heap[0] = input[inputArrayIndex];
                maxHeapify(heap, 0, heap.length);
            }
        }
        for (int heapIndex = 0; heapIndex < heap.length; heapIndex++)
            System.out.println(heap[heapIndex]);
    }

    private void buildMinHeap(int[] heap) {
        for (int index = heap.length / 2 - 1; index >= 0; index--)
            minHeapify(heap, index, heap.length);
    }

    private void minHeapify(int[] heap, int rootIndex, int endIndex) {
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        int smallerElementIndex = rootIndex;
        if (leftChildIndex < endIndex && heap[rootIndex] > heap[leftChildIndex])
            smallerElementIndex = leftChildIndex;
        if (rightChildIndex < endIndex && heap[smallerElementIndex] > heap[rightChildIndex])
            smallerElementIndex = rightChildIndex;
        if (smallerElementIndex != rootIndex) {
            swap(heap, rootIndex, smallerElementIndex);
            minHeapify(heap, smallerElementIndex, endIndex);
        }
    }

    private int extractMin(int[] heap, int index) {
        int minElement = heap[0];
        int heapLength = heap.length - 1;
        swap(heap, 0, heapLength - index);
        minHeapify(heap, 0, heapLength - index);
        return minElement;
    }

    private void buildMaxHeap(int[] heap) {
        for (int index = heap.length / 2 - 1; index >= 0; index--)
            maxHeapify(heap, index, heap.length);
    }

    private void maxHeapify(int[] heap, int rootIndex, int endIndex) {
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        int higherElementIndex = rootIndex;
        if (leftChildIndex < endIndex && heap[rootIndex] < heap[leftChildIndex])
            higherElementIndex = leftChildIndex;
        if (rightChildIndex < endIndex && heap[higherElementIndex] < heap[rightChildIndex])
            higherElementIndex = rightChildIndex;
        if (rootIndex != higherElementIndex) {
            swap(heap, rootIndex, higherElementIndex);
            maxHeapify(heap, higherElementIndex, endIndex);
        }
    }

    private void swap(int[] heap, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            heap[firstIndex] = heap[firstIndex] ^ heap[secondIndex];
            heap[secondIndex] = heap[secondIndex] ^ heap[firstIndex];
            heap[firstIndex] = heap[firstIndex] ^ heap[secondIndex];
        }
    }
}
