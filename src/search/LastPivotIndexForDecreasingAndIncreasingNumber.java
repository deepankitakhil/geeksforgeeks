package search;

/**
 * Created by Deepankit on 8/21/2016.
 */
public class LastPivotIndexForDecreasingAndIncreasingNumber {
    public static void main(String[] args) {
        LastPivotIndexForDecreasingAndIncreasingNumber lastPivotIndexForDecreasingAndIncreasingNumber = new LastPivotIndexForDecreasingAndIncreasingNumber();
        System.out.println(lastPivotIndexForDecreasingAndIncreasingNumber.findLastPivotIndex(new int[]{2, 3, 4, 6, 8, 5, 5}));

    }

    public int findLastPivotIndex(int[] input) {
        int[] leftMax = new int[input.length];
        int[] rightMin = new int[input.length];
        leftMax[0] = Integer.MIN_VALUE;
        rightMin[input.length - 1] = Integer.MAX_VALUE;
        for (int index = 1; index < input.length; index++) {
            leftMax[index] = leftMax[index - 1] > input[index - 1] ? leftMax[index - 1] : input[index - 1];
        }
        for (int index = input.length - 1; index >= 1; index--) {
            rightMin[index - 1] = rightMin[index] < input[index] ? rightMin[index] : input[index];
        }

        for (int index = 0; index < input.length; index++)
            if (input[index] > leftMax[index] && input[index] < rightMin[index])
                return index;
        return -1;
    }
}
