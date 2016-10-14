package arrays;

/**
 * Created by Deepankit on 10/13/2016.
 */
public class PairInArrayCloserToAGivenSum {

    public static void main(String[] args) throws Exception {
        PairInArrayCloserToAGivenSum pairInArrayCloserToAGivenSum = new PairInArrayCloserToAGivenSum();
        int[] input = new int[]{10, 22, 28, 29, 30, 40};
        pairInArrayCloserToAGivenSum.validate(input);
        int sum = 10;
        pairInArrayCloserToAGivenSum.findClosestPairForGivenSum(input, sum);
    }

    private void findClosestPairForGivenSum(int[] input, int sum) {
        int leftIndex = 0;
        int rightIndex = input.length - 1;
        int difference = Integer.MAX_VALUE;
        int resultantLeftIndex = Integer.MAX_VALUE;
        int resultantRightIndex = Integer.MAX_VALUE;
        while (leftIndex < rightIndex) {
            int calculatedDifference = Math.abs(input[leftIndex] + input[rightIndex] - sum);
            if (calculatedDifference < difference) {
                difference = calculatedDifference;
                resultantLeftIndex = leftIndex;
                resultantRightIndex = rightIndex;
            }
            if (input[leftIndex] + input[rightIndex] < sum)
                leftIndex++;
            else
                rightIndex--;
        }

        System.out.println(resultantLeftIndex + "----" + resultantRightIndex);
    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }
}
