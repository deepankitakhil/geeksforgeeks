package search;

/**
 * Created by Deepankit on 8/20/2016.
 */
public class IterativeBinarySearch {

    public static void main(String[] args) {
        IterativeBinarySearch iterativeBinarySearch = new IterativeBinarySearch();
        System.out.println(iterativeBinarySearch.search(new int[]{1, 2, 3, 4, 5, 6}, -3));
    }

    public int search(int[] input, int searchElement) {
        if (input.length == 0)
            return -1;
        return searchElementIn(input, 0, input.length - 1, searchElement);
    }

    private int searchElementIn(int[] input, int startIndex, int endIndex, int searchElement) {
        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (input[middleIndex] == searchElement)
                return middleIndex;
            if (input[middleIndex] > searchElement)
                endIndex = middleIndex - 1;
            else
                startIndex = middleIndex + 1;
        }
        return -(startIndex + 1);
    }
}
