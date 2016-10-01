package search;

/**
 * Created by Deepankit on 8/28/2016.
 */
public class FindOddElementInPairsOfElements {

    public static void main(String[] args) {
        FindOddElementInPairsOfElements findOddElementInPairsOfElements = new FindOddElementInPairsOfElements();
        System.out.println(findOddElementInPairsOfElements.search(new int[]{1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}));
    }

    private int search(int[] input) {
        if (input.length > 0) {
            int elementIndex = searchElement(input, 0, input.length - 1);
            return input[elementIndex];
        }
        return -1;
    }

    private int searchElement(int[] input, int startIndex, int endIndex) {
        if (startIndex == endIndex)
            return startIndex;
        if (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (mid % 2 != 0) {
                if (input[mid] != input[mid + 1])
                    return searchElement(input, mid + 1, endIndex);
                else
                    return searchElement(input, startIndex, mid);
            } else {
                if (input[mid] != input[mid + 1])
                    return searchElement(input, startIndex, mid);
                else
                    return searchElement(input, mid + 1, endIndex);
            }
        }
        return -1;
    }
}
