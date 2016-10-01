package search;

/**
 * Created by Deepankit on 8/31/2016.
 */
public class MinimumElementInRotatedSortedArray {

    public static void main(String[] args) {
        MinimumElementInRotatedSortedArray minimumElementInRotatedSortedArray = new MinimumElementInRotatedSortedArray();
        System.out.println(minimumElementInRotatedSortedArray.findMinElement(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    private int findMinElement(int[] input) {

        if (input.length > 0)
            return findElementIndex(input, 0, input.length - 1);
        return Integer.MIN_VALUE;
    }

    private int findElementIndex(int[] input, int startIndex, int endIndex) {
        int mid;
        if (startIndex == endIndex || input[startIndex] < input[endIndex])
            return startIndex;
        if (startIndex < endIndex) {
            mid = startIndex + (endIndex - startIndex) / 2;
            if (input[startIndex] > input[mid])
                return findElementIndex(input, startIndex, mid);
            else
                return findElementIndex(input, mid + 1, endIndex);
        }
        return Integer.MIN_VALUE;
    }

}
