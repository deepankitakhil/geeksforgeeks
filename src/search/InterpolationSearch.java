package search;

/**
 * Created by Deepankit on 9/17/2016.
 */
public class InterpolationSearch {

    public static void main(String[] args) {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int key = 123;
        int[] input = new int[]{2, 3, 5, 67, 89, 100, 123};
        System.out.println(interpolationSearch.search(input, key));

    }

    private int search(int[] input, int key) {
        if (input.length > 0)
            return interpolationSearch(input, 0, input.length - 1, key);
        return Integer.MIN_VALUE;
    }

    private int interpolationSearch(int[] input, int startIndex, int endIndex, int key) {
        int midIndex;
        if (input[startIndex] == key)
            return startIndex;
        if (startIndex < endIndex) {
            midIndex = (endIndex - startIndex) / (input[endIndex] - input[startIndex]) * key + startIndex;
            if (input[midIndex] == key)
                return midIndex;
            if (input[midIndex] > key)
                return interpolationSearch(input, startIndex, midIndex - 1, key);
            return interpolationSearch(input, midIndex + 1, endIndex, key);
        }
        return Integer.MIN_VALUE;
    }
}
