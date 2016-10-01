package search;

/**
 * Created by Deepankit on 8/20/2016.
 */
public class RecursiveBinarySearch {

    public static void main(String[] args) {
        RecursiveBinarySearch recursiveBinarySearch = new RecursiveBinarySearch();
        System.out.println(recursiveBinarySearch.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 10));
    }

    public int search(int[] input, int searchElement) {
        if (input.length == 0)
            return -999;
        return searchElementIn(input, 0, input.length - 1, searchElement);
    }

    private int searchElementIn(int[] input, int startIndex, int endIndex, int searchElement) {

        if (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (searchElement == input[middleIndex])
                return middleIndex;
            if (input[middleIndex] > searchElement)
                return searchElementIn(input, startIndex, middleIndex - 1, searchElement);
            else
                return searchElementIn(input, middleIndex + 1, endIndex, searchElement);
        }
        return -(startIndex + 1);
    }

}
