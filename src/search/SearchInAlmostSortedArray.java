package search;

/**
 * Created by Deepankit on 10/11/2016.
 */
public class SearchInAlmostSortedArray {
    public static void main(String[] args) throws Exception {
        SearchInAlmostSortedArray searchInAlmostSortedArray = new SearchInAlmostSortedArray();
        int[] input = new int[]{2, 3, 10, 4, 40};
        searchInAlmostSortedArray.validate(input);
        int searchElement = 2;
        System.out.println(searchInAlmostSortedArray.findElementIndex(input, searchElement));
    }

    private int findElementIndex(int[] input, int searchElement) {
        return findElementIndexUsingBinarySearch(input, 0, input.length, searchElement);
    }

    private int findElementIndexUsingBinarySearch(int[] input, int startIndex, int endIndex, int searchElement) {

        if (input[startIndex] == searchElement)
            return startIndex;
        if (startIndex < endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (input[midIndex] == searchElement)
                return midIndex;
            else if (midIndex > startIndex && input[midIndex - 1] == searchElement)
                return midIndex - 1;
            else if (midIndex < endIndex && input[midIndex + 1] == searchElement)
                return midIndex + 1;
            else if (input[midIndex] > midIndex)
                return findElementIndexUsingBinarySearch(input, startIndex, midIndex - 2, searchElement);
            else
                return findElementIndexUsingBinarySearch(input, midIndex + 2, endIndex, searchElement);
        }
        return -(startIndex + 1);
    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }
}
