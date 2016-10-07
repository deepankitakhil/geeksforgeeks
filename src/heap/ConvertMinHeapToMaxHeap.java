package heap;

/**
 * Created by Deepankit on 10/5/2016.
 */
@SuppressWarnings("Duplicates")
public class ConvertMinHeapToMaxHeap {
    public static void main(String[] args) {
        ConvertMinHeapToMaxHeap convertMinHeapToMaxHeap = new ConvertMinHeapToMaxHeap();
        int[] input = new int[]{3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        convertMinHeapToMaxHeap.convert(input);
        display(input);
    }

    private static void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void convert(int[] input) {
        for (int index = input.length / 2 - 1; index >= 0; index--)
            maxHeapify(input, index, input.length);
    }

    private void maxHeapify(int[] input, int rootIndex, int endIndex) {
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        int biggerElementIndex = rootIndex;
        if (leftChildIndex < endIndex && input[rootIndex] < input[leftChildIndex])
            biggerElementIndex = leftChildIndex;
        if (rightChildIndex < endIndex && input[biggerElementIndex] < input[rightChildIndex])
            biggerElementIndex = rightChildIndex;
        if (biggerElementIndex != rootIndex && biggerElementIndex < endIndex) {
            swap(input, rootIndex, biggerElementIndex);
            maxHeapify(input, biggerElementIndex, endIndex);
        }
    }

    private void swap(int[] input, int firstIndex, int secondIndex) {
        input[firstIndex] = input[firstIndex] ^ input[secondIndex];
        input[secondIndex] = input[firstIndex] ^ input[secondIndex];
        input[firstIndex] = input[firstIndex] ^ input[secondIndex];
    }

}
