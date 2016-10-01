package search;

/**
 * Created by Deepankit on 9/1/2016.
 */
public class CeilingInSortedArray {
    public static void main(String[] args) {
        CeilingInSortedArray ceilingInSortedArray = new CeilingInSortedArray();
        System.out.println(ceilingInSortedArray.findCeiling(new int[]{1, 2, 8, 10, 10, 12, 19}, 100));
    }

    private int findCeiling(int[] input, int pivot) {
        if (input.length > 0)
            return findIndex(input, 0, input.length - 1, pivot);
        return Integer.MIN_VALUE;
    }

    private int findIndex(int[] input, int startIndex, int endIndex, int pivot) {
        int mid = 0;
        while (startIndex <= endIndex) {
            if (startIndex == endIndex && input[startIndex] >= pivot)
                return startIndex;
            mid = startIndex + (endIndex - startIndex) / 2;
            if (input[mid] >= pivot)
                endIndex = mid;
            else
                startIndex = mid + 1;
        }
        if (input[mid] > pivot)
            return mid;
        else
            return Integer.MIN_VALUE;
    }

}
