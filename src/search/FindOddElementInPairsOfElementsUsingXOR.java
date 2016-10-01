package search;

/**
 * Created by Deepankit on 8/28/2016.
 */
public class FindOddElementInPairsOfElementsUsingXOR {

    public static void main(String[] args) {
        FindOddElementInPairsOfElementsUsingXOR findOddElementInPairsOfElements = new FindOddElementInPairsOfElementsUsingXOR();
        System.out.println(findOddElementInPairsOfElements.search(new int[]{1, 1, 2, 2, 1, 1, 2, 2, 13, 1, 1, 40, 40, 13, 13}));
    }

    private int search(int[] input) {
        if (input.length > 0) {
            int result = 0;
            for (int element : input) {
                result = element ^ result;
            }
            return result;
        }
        return -1;
    }

}
