package heap;

/**
 * Created by Deepankit on 10/6/2016.
 */
@SuppressWarnings("Duplicates")
public class FindKLargestElements {
    public static void main(String[] args) throws Exception {
        FindKLargestElements findKLargestElements = new FindKLargestElements();
        int index = 4;
        int[] input = new int[]{12, 3, 5, 7, 19};
        findKLargestElements.validateInput(input, index);
        findKLargestElements.findKLargestElementsUsingMaxHeap(input, index);
        findKLargestElements.findKLargestElementsUsingMinHeap(input, index);
    }

    private void validateInput(int[] input, int index) throws Exception {
        if (input == null || input.length == 0 || index > input.length)
            throw new Exception("invalid input. Either input array is null or is of length 0 or index is greater than aray length");
    }


    private void findKLargestElementsUsingMaxHeap(int[] input, int index) {
        int[] heap = new int[input.length];
        for (int heapIndex = 0; heapIndex < heap.length; heapIndex++)
            heap[heapIndex] = input[heapIndex];
        buildMaxHeap(heap);
        for (int heapIndex = 0; heapIndex < index; heapIndex++) {
            extractMaxFromMaxHeap(heap, heapIndex);
        }
    }

    private void buildMaxHeap(int[] heap) {
        for (int index = heap.length / 2 - 1; index >= 0; index--)
            maxHeapify(heap, index, heap.length);
    }

    private void maxHeapify(int[] heap, int rootIndex, int endIndex) {
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        int biggerElementIndex = rootIndex;
        if (leftChildIndex < endIndex && heap[rootIndex] < heap[leftChildIndex])
            biggerElementIndex = leftChildIndex;
        if (rightChildIndex < endIndex && heap[biggerElementIndex] < heap[leftChildIndex])
            biggerElementIndex = rightChildIndex;
        if (biggerElementIndex != rootIndex) {
            swap(heap, biggerElementIndex, rootIndex);
            maxHeapify(heap, biggerElementIndex, endIndex);
        }
    }

    private void extractMaxFromMaxHeap(int[] heap, int index) {
        int maxElement = heap[0];
        int endIndex = heap.length - index - 1;
        swap(heap, 0, endIndex);
        maxHeapify(heap, 0, endIndex);
        System.out.println(maxElement);
    }

    private void swap(int[] heap, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            heap[firstIndex] = heap[firstIndex] ^ heap[secondIndex];
            heap[secondIndex] = heap[firstIndex] ^ heap[secondIndex];
            heap[firstIndex] = heap[firstIndex] ^ heap[secondIndex];
        }
    }

    private void findKLargestElementsUsingMinHeap(int[] input, int index) {
        int heap[] = new int[index];
        for (int heapIndex = 0; heapIndex < heap.length; heapIndex++)
            heap[heapIndex] = input[heapIndex];
        buildMinHeap(heap);
        for (int arrayIndex = index; arrayIndex < input.length; arrayIndex++) {
            if (heap[0] < input[arrayIndex]) {
                heap[0] = input[arrayIndex];
                minHeapify(heap, 0, heap.length);
            }
        }

        for (int heapIndex = 0; heapIndex < index; heapIndex++)
            System.out.println(heap[heapIndex]);
    }

    private void buildMinHeap(int[] heap) {
        int heapLength = heap.length;
        for (int index = heapLength / 2 - 1; index >= 0; index--)
            minHeapify(heap, index, heapLength);
    }

    private void minHeapify(int[] heap, int rootIndex, int endIndex) {
        int leftElementIndex = 2 * rootIndex + 1;
        int rightElementIndex = 2 * rootIndex + 2;
        int smallerElementIndex = rootIndex;
        if (leftElementIndex < endIndex && heap[rootIndex] > heap[leftElementIndex])
            smallerElementIndex = leftElementIndex;
        if (rightElementIndex < endIndex && heap[smallerElementIndex] > heap[rightElementIndex])
            smallerElementIndex = rightElementIndex;
        if (smallerElementIndex != rootIndex) {
            swap(heap, smallerElementIndex, rootIndex);
            minHeapify(heap, smallerElementIndex, endIndex);
        }
    }
}
