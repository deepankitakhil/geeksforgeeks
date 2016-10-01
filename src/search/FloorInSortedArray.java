package search;

/**
 * Created by Deepankit on 8/20/2016.
 */
public class FloorInSortedArray {

    public static void main(String[] args) {
        FloorInSortedArray floorInSortedArray = new FloorInSortedArray();
        System.out.println(floorInSortedArray.floorValue(new int[]{1, 2, 8, 10, 10, 12, 19}, 20));
    }

    public int floorValue(int[] input, int searchElement) {
        int startIndex = 0;
        int endIndex = input.length - 1;
        int midIndex = 0;
        while (startIndex <= endIndex) {
            midIndex = startIndex + (endIndex - startIndex) / 2;
            if (input[midIndex] == searchElement)
                return searchElement;
            if (input[midIndex] > searchElement)
                endIndex = midIndex - 1;
            else
                startIndex = midIndex + 1;
        }
        return endIndex;
    }
}
