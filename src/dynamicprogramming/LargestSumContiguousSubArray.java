package dynamicprogramming;

/**
 * Created by Deepankit on 10/10/2016.
 */
public class LargestSumContiguousSubArray {
    public static void main(String[] args) throws Exception {
        LargestSumContiguousSubArray largestSumContiguousSubArray = new LargestSumContiguousSubArray();
        int[] input = new int[]{20, -3, 4, -1, -2, 1, 5, -3};
        largestSumContiguousSubArray.validate(input);
        System.out.println(largestSumContiguousSubArray.findMaxSum(input));
    }

    private int findMaxSum(int[] input) {
        int maxSum = input[0];
        int overAllSum = input[0];
        for (int index = 1; index < input.length; index++) {
            maxSum = max(0, maxSum + input[index]);
            overAllSum = max(overAllSum, maxSum);
        }
        return overAllSum;
    }

    private int max(int inputOne, int inputTwo) {
        return inputOne > inputTwo ? inputOne : inputTwo;
    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }
}
