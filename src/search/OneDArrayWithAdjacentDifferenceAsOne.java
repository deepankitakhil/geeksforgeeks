package search;

/**
 * Created by Deepankit on 8/28/2016.
 */
public class OneDArrayWithAdjacentDifferenceAsOne {

    public static void main(String[] args) {
        OneDArrayWithAdjacentDifferenceAsOne oneDArrayWithAdjacentDifferenceAsOne = new OneDArrayWithAdjacentDifferenceAsOne();
        System.out.println(oneDArrayWithAdjacentDifferenceAsOne.findIndex(new int[]{1, 2, 3, 4, 5, 4}, 5));

    }

    private int findIndex(int[] input, int searchNumber) {
        int index = 0;
        int possibleIndex;
        while (index < input.length) {
            possibleIndex = Math.abs(input[index] - searchNumber);
            int nextPossibleIndex = index + possibleIndex;
            if (searchNumber == input[nextPossibleIndex])
                return nextPossibleIndex;
            else
                index += possibleIndex;
        }
        return -1;
    }
}
