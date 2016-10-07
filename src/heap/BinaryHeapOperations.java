package heap;

/**
 * Created by Deepankit on 10/5/2016.
 */
@SuppressWarnings("Duplicates")
public class BinaryHeapOperations {
    public static void main(String[] args) throws Exception {
        BinaryHeapOperations binaryHeapOperations = new BinaryHeapOperations();
        int[] input = new int[]{100, 200, 3, 4, 5, 6, 7, 8, 9};
        int index = 5;
        int element = 2;
        binaryHeapOperations.validateInput(input);
        binaryHeapOperations.buildHeap(input);
        binaryHeapOperations.display(input);
        binaryHeapOperations.deleteKey(input, index);
        binaryHeapOperations.display(input);
        System.out.println(binaryHeapOperations.extractMax(input));
        binaryHeapOperations.display(input);
        binaryHeapOperations.insert(input, element, index);
        binaryHeapOperations.display(input);
        binaryHeapOperations.decreaseKey(input, 0, element);
        binaryHeapOperations.display(input);
    }

    private void decreaseKey(int[] input, int index, int element) {
        input[index] = element;
        maintainMaxHeapifyPropertyWhenKeyValueDecreases(input, index);
    }

    private void maintainMaxHeapifyPropertyWhenKeyValueDecreases(int[] input, int index) {
        int rightChildIndex = 2 * index + 1;
        int leftChildIndex = 2 * index + 2;
        int biggerElementIndex = leftChildIndex;
        if (leftChildIndex < input.length && input[index] < input[leftChildIndex])
            biggerElementIndex = index;
        if (rightChildIndex < input.length && input[biggerElementIndex] < input[rightChildIndex])
            biggerElementIndex = rightChildIndex;
        if (biggerElementIndex != index && biggerElementIndex < input.length) {
            swap(input, biggerElementIndex, index);
            maintainMaxHeapifyPropertyWhenKeyValueDecreases(input, biggerElementIndex);
        }
    }

    private int extractMax(int[] input) {
        swap(input, 0, input.length - 1);
        maxHeapify(input, 0, input.length - 1);
        return input[input.length - 1];
    }

    private void insert(int[] input, int element, int index) {
        if (input[index] > element) {
            input[index] = element;
            maintainMaxHeapifyPropertyWhenKeyValueDecreases(input, index);
        } else {
            input[index] = element;
            maintainMaxHeapifyPropertyWhenKeyValueIncreases(input, index);
        }
    }

    private void maintainMaxHeapifyPropertyWhenKeyValueIncreases(int[] input, int index) {
        int rootIndex = (index - 1) / 2;
        if (input[rootIndex] < input[index] && index != 0) {
            swap(input, rootIndex, index);
            maintainMaxHeapifyPropertyWhenKeyValueIncreases(input, rootIndex);
        }
    }

    private void deleteKey(int[] input, int index) {
        input[index] = Integer.MIN_VALUE;
        maxHeapify(input, 0, index);
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void buildHeap(int[] input) {
        for (int index = input.length / 2 - 1; index >= 0; index--)
            maxHeapify(input, index, input.length);
    }

    private void maxHeapify(int[] input, int rootIndex, int endIndex) {
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        int highestElementIndex = rootIndex;
        if (leftChildIndex < endIndex && input[rootIndex] < input[leftChildIndex])
            highestElementIndex = leftChildIndex;
        if (rightChildIndex < endIndex && input[highestElementIndex] < input[rightChildIndex])
            highestElementIndex = rightChildIndex;
        if (highestElementIndex != rootIndex && highestElementIndex < endIndex) {
            swap(input, highestElementIndex, rootIndex);
            maxHeapify(input, highestElementIndex, endIndex);
        }
    }

    private void swap(int[] input, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            input[firstIndex] = input[firstIndex] ^ input[secondIndex];
            input[secondIndex] = input[firstIndex] ^ input[secondIndex];
            input[firstIndex] = input[firstIndex] ^ input[secondIndex];
        }

    }

    private void validateInput(int[] input) throws Exception {
        if (input.length == 0)
            throw new Exception("array length can't be 0");
    }
}
