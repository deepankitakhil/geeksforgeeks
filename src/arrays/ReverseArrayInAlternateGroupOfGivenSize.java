package arrays;

/**
 * Created by Deepankit on 9/23/2016.
 */
public class ReverseArrayInAlternateGroupOfGivenSize {
    public static void main(String[] args) {
        ReverseArrayInAlternateGroupOfGivenSize reverseArrayInAlternateGroupOfGivenSize = new ReverseArrayInAlternateGroupOfGivenSize();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int blockSize = 4;
        reverseArrayInAlternateGroupOfGivenSize.reverse(input, blockSize);
        reverseArrayInAlternateGroupOfGivenSize.display(input);
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void reverse(int[] input, int blockSize) {
        if (blockSize > 1 && blockSize <= input.length) {
            int endIndex = blockSize - 1;
            int blockCount = 1;
            int blockMidIndex = blockSize / 2;
            int ceilBlockSize = (int) Math.ceil((double) blockSize / 2);
            for (int index = 0; index < input.length - ceilBlockSize; index++) {
                if (blockMidIndex == index % blockSize) {
                    blockCount = blockCount + 2;
                    endIndex = blockCount * blockSize - 1;
                    index = endIndex - blockSize + 1;
                }
                if (endIndex > input.length - 1)
                    return;
                swap(input, index, endIndex--);
            }
        }

    }

    private void swap(int[] input, int firstIndex, int secondIndex) {
        input[firstIndex] = input[firstIndex] ^ input[secondIndex];
        input[secondIndex] = input[firstIndex] ^ input[secondIndex];
        input[firstIndex] = input[firstIndex] ^ input[secondIndex];
    }
}
