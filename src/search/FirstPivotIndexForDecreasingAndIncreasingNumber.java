package search;

/**
 * Created by Deepankit on 8/20/2016.
 */
public class FirstPivotIndexForDecreasingAndIncreasingNumber {

    public static void main(String[] args) {
        FirstPivotIndexForDecreasingAndIncreasingNumber firstPivotIndexForDecreasingAndIncreasingNumber = new FirstPivotIndexForDecreasingAndIncreasingNumber();
        System.out.println(firstPivotIndexForDecreasingAndIncreasingNumber.search(new int[]{2, 1, 4, 3, 6, 8, 5, 9}));
    }

    public int search(int[] input) {
        int maxElement = input[0];
        int pivotIndex = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] >= maxElement) {
                maxElement = input[i];
                pivotIndex = i;
                if (input[pivotIndex + 1] > maxElement) {
                    break;
                }
            }
        }
        for (int i = pivotIndex + 1; i < input.length; i++) {
            if (input[i] < maxElement) {
                return -1;
            }
        }
        return pivotIndex;
    }

}
