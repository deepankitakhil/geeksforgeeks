package search;

/**
 * Created by Deepankit on 9/17/2016.
 */
public class FixedPointInAArray {
    public static void main(String[] args) {
        FixedPointInAArray fixedPointInAArray = new FixedPointInAArray();
        int[] input = new int[]{-10, -5, 3, 4, 7, 9};
        System.out.println(fixedPointInAArray.findPoint(input));
    }

    private int findPoint(int[] input) {
        if (input.length > 0)
            return findFixedPoint(input, 0, input.length - 1);
        return Integer.MIN_VALUE;
    }

    private int findFixedPoint(int[] input, int startIndex, int endIndex) {
        int midIndex;
        if (startIndex < endIndex) {
            midIndex = startIndex + (endIndex - startIndex) / 2;
            if (midIndex == input[midIndex])
                return midIndex;
            else if (input[midIndex] > midIndex)
                return findFixedPoint(input, startIndex, midIndex - 1);
            else
                return findFixedPoint(input, midIndex + 1, endIndex);
        }
        return Integer.MIN_VALUE;
    }
}
