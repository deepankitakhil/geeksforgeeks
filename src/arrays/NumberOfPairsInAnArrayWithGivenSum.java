package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Deepankit on 10/13/2016.
 */
public class NumberOfPairsInAnArrayWithGivenSum {
    public static void main(String[] args) throws Exception {
        NumberOfPairsInAnArrayWithGivenSum numberOfPairsInAnArrayWithGivenSum = new NumberOfPairsInAnArrayWithGivenSum();
        int[] input = new int[]{20, 30, 40, 50, 0, 10, 25, -10, 35, 60};
        numberOfPairsInAnArrayWithGivenSum.validate(input);
        int sum = 50;
        System.out.println(numberOfPairsInAnArrayWithGivenSum.findNumberOfPairsForGivenSum(input, sum));
    }

    private int findNumberOfPairsForGivenSum(int[] input, int sum) {
        Set<Integer> differenceOfSumForEachElement = new HashSet<>();
        int count = 0;
        for (int index = 0; index < input.length; index++)
            if (!differenceOfSumForEachElement.contains(input[index]))
                differenceOfSumForEachElement.add(Math.abs(sum - input[index]));
            else {
                count++;
            }

        return count;
    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }
}
