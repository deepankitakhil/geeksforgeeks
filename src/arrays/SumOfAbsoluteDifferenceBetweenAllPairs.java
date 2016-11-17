package arrays;

import java.util.Arrays;

/**
 * Created by Deepankit on 11/15/2016.
 */
public class SumOfAbsoluteDifferenceBetweenAllPairs {
  public static void main(String[] args) {
    SumOfAbsoluteDifferenceBetweenAllPairs sumOfAbsoluteDifferenceBetweenAllPairs = new SumOfAbsoluteDifferenceBetweenAllPairs();
    System.out.println(sumOfAbsoluteDifferenceBetweenAllPairs.findSumOfAbsoluteDifference(new int[]{1, 2, 3, 4, 5, 7, 9, 11, 14}));
  }

  private int findSumOfAbsoluteDifference(int[] input) {
    int sum = 0;
    int sumOfAbsoluteDifference = 0;
    Arrays.sort(input);
    for (int index = 0; index < input.length; index++)
      sum += input[index];
    for (int index = 0; index < input.length; index++) {
      sum = sum - input[index];
      sumOfAbsoluteDifference += sum - (input.length - 1 - index) * input[index];
    }
    return sumOfAbsoluteDifference;
  }
}
