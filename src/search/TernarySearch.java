package search;

/**
 * Created by Deepankit on 10/13/2016.
 */
public class TernarySearch {
    public static void main(String[] args) {
        TernarySearch ternarySearch = new TernarySearch();
        int searchElement = 4;
        int[] input = new int[]{2, 3, 4, 10, 40};
        System.out.println(ternarySearch.search(input, searchElement));
    }

    private int search(int[] input, int searchElement) {
        return recursiveTernarySearch(input, 0, input.length, searchElement);
    }

    private int recursiveTernarySearch(int[] input, int startIndex, int endIndex, int searchElement) {
        if (startIndex == endIndex && input[startIndex] == searchElement)
            return startIndex;
        if (startIndex < endIndex) {
            int firstThirdIndex = startIndex + (endIndex - startIndex) / 3;
            int secondThirdIndex = startIndex + 2 * (endIndex - startIndex) / 3;

            if (input[firstThirdIndex] == searchElement)
                return firstThirdIndex;
            else if (input[secondThirdIndex] == searchElement)
                return secondThirdIndex;
            else if (input[firstThirdIndex] > searchElement)
                return recursiveTernarySearch(input, startIndex, firstThirdIndex, searchElement);
            else if (input[secondThirdIndex] < searchElement)
                return recursiveTernarySearch(input, secondThirdIndex, endIndex, searchElement);
            else
                return recursiveTernarySearch(input, firstThirdIndex + 1, secondThirdIndex - 1, searchElement);

        }
        return Integer.MIN_VALUE;
    }
}
