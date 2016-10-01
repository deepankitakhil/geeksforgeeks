package arrays;

/**
 * Created by Deepankit on 9/23/2016.
 */
public class ReverseSubArrayFormedByKElementsAtGivenDistance {
    public static void main(String[] args) {
        ReverseSubArrayFormedByKElementsAtGivenDistance reverseSubArrayFormedByKElementsAtGivenDistance = new ReverseSubArrayFormedByKElementsAtGivenDistance();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int blockSize = 3;
        int distance = 1;
        reverseSubArrayFormedByKElementsAtGivenDistance.reverse(input, blockSize, distance);
        reverseSubArrayFormedByKElementsAtGivenDistance.display(input);
    }

    private void reverse(int[] input, int blockSize, int distance) {
        int startIndex = 0;
        int endIndex;
        while (startIndex < input.length) {
            endIndex = startIndex + blockSize - 1;
            endIndex = endIndex < input.length ? endIndex : input.length - 1;
            while (startIndex < endIndex)
                swap(input, startIndex++, endIndex--);
            startIndex = startIndex + blockSize + distance - 1;
            startIndex = startIndex < input.length ? startIndex : endIndex + (int) Math.floor(blockSize / 2.0) + 1;
        }
    }

    private void swap(int[] input, int firstIndex, int secondIndex) {
        input[firstIndex] = input[firstIndex] ^ input[secondIndex];
        input[secondIndex] = input[firstIndex] ^ input[secondIndex];
        input[firstIndex] = input[firstIndex] ^ input[secondIndex];
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }
}
