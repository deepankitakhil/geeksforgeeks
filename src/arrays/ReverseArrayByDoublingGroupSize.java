package arrays;

/**
 * Created by Deepankit on 9/23/2016.
 */
public class ReverseArrayByDoublingGroupSize {
    public static void main(String[] args) {
        ReverseArrayByDoublingGroupSize reverseArrayByDoublingGroupSize = new ReverseArrayByDoublingGroupSize();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int blockSize = 1;
        reverseArrayByDoublingGroupSize.reverse(input, blockSize);
        reverseArrayByDoublingGroupSize.display(input);
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void reverse(int[] input, int blockSize) {
        int startIndex = 0;
        int endIndex;
        while (startIndex + blockSize <= input.length) {
            endIndex = startIndex + blockSize - 1;
            while (startIndex < endIndex) {
                swap(input, startIndex++, endIndex--);
            }
            startIndex = startIndex + (int) (Math.ceil(blockSize / 2.0));
            blockSize *= 2;
        }
    }

    private void swap(int[] input, int firstIndex, int secondIndex) {
        input[firstIndex] = input[firstIndex] ^ input[secondIndex];
        input[secondIndex] = input[firstIndex] ^ input[secondIndex];
        input[firstIndex] = input[firstIndex] ^ input[secondIndex];
    }
}
