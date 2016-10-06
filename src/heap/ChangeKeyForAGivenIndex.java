package heap;

/**
 * Created by Deepankit on 10/5/2016.
 */
public class ChangeKeyForAGivenIndex {
    public static void main(String[] args) throws Exception {
        ChangeKeyForAGivenIndex changeKeyForAGivenIndex = new ChangeKeyForAGivenIndex();
        int index = 1;
        int newKey = 10;
        int[] input = new int[]{3, 1, 2};
        changeKeyForAGivenIndex.validateInput(input, index);
        changeKeyForAGivenIndex.decreaseKey(input, index, newKey);
        changeKeyForAGivenIndex.display(input);
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void decreaseKey(int[] input, int index, int newKey) {
        input[index] = newKey;
        maxHeapify(input);
    }

    private void maxHeapify(int[] input) {
        for (int index = input.length / 2 - 1; index >= 0; index--)
            heapify(input, index, input.length - 1);
    }

    private void heapify(int[] input, int rootIndex, int endIndex) {
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;
        int biggerValueIndex = rootIndex;
        if (leftChildIndex < endIndex && input[leftChildIndex] > input[rootIndex])
            biggerValueIndex = leftChildIndex;
        if (rightChildIndex < endIndex && input[biggerValueIndex] < input[rightChildIndex])
            biggerValueIndex = rightChildIndex;
        if (biggerValueIndex != rootIndex && biggerValueIndex < endIndex) {
            swap(input, biggerValueIndex, rootIndex);
            heapify(input, biggerValueIndex, endIndex);
        }
    }

    private void swap(int[] input, int biggerValueIndex, int rootIndex) {
        if (biggerValueIndex != rootIndex) {
            input[biggerValueIndex] = input[biggerValueIndex] ^ input[rootIndex];
            input[rootIndex] = input[biggerValueIndex] ^ input[rootIndex];
            input[biggerValueIndex] = input[biggerValueIndex] ^ input[rootIndex];
        }
    }

    private void validateInput(int[] input, int index) throws Exception {
        if (input.length == 0)
            throw new Exception("Array should be minimum of length 1");
        if (index > input.length - 1)
            throw new Exception("invalid index");
    }
}
