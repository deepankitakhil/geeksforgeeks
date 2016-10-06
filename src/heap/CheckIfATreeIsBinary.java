package heap;

/**
 * Created by Deepankit on 10/4/2016.
 */
public class CheckIfATreeIsBinary {
    public static void main(String[] args) {
        CheckIfATreeIsBinary checkIfATreeIsBinary = new CheckIfATreeIsBinary();
        int[] input = new int[]{90, 15, 10, 7, 12, 2};
        System.out.println(checkIfATreeIsBinary.isBinary(input));
    }

    private boolean isBinary(int[] input) {
        for (int index = input.length / 2 - 1; index >= 0; index--)
            return isMaxHeap(input, index);
        return false;
    }

    private boolean isMaxHeap(int[] input, int index) {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;
        boolean result = false;
        if (leftChildIndex < input.length && input[index] > input[leftChildIndex])
            result = true;
        if (rightChildIndex < input.length && input[index] < input[rightChildIndex])
            result = false;
        return result;
    }
}
