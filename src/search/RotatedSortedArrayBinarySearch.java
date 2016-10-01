package search;

/**
 * Created by Deepankit on 8/31/2016.
 */
public class RotatedSortedArrayBinarySearch {

    public static void main(String[] args) {
        RotatedSortedArrayBinarySearch rotatedSortedArrayBinarySearch = new RotatedSortedArrayBinarySearch();
        System.out.println(rotatedSortedArrayBinarySearch.search(new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 7));
    }

    private int search(int[] input, int searchElement) {
        if (input.length > 0)
            return rotatedBinarySearch(input, 0, input.length - 1, searchElement);
        return -999;
    }

    private int rotatedBinarySearch(int[] input, int startIndex, int endIndex, int searchElement) {
        if (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (input[mid] == searchElement)
                return mid;
            if (input[startIndex] < input[mid]) {
                if (searchElement >= input[startIndex] && searchElement < input[mid])
                    return rotatedBinarySearch(input, startIndex, mid, searchElement);
                else
                    return rotatedBinarySearch(input, mid + 1, endIndex, searchElement);
            } else {
                if (searchElement > input[mid] && searchElement <= input[endIndex])
                    return rotatedBinarySearch(input, mid + 1, endIndex, searchElement);
                else
                    return rotatedBinarySearch(input, startIndex, mid - 1, searchElement);
            }
        }
        return -999;
    }
}
