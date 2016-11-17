package arrays;

import java.util.HashMap;
import java.util.Map;

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
    int pairs = 0;

    Map<Integer, Integer> map = new HashMap<>();
    for (int index = 0; index < input.length; index++)
      if (map.get(input[index]) == null) map.put(input[index], 1);
      else map.put(input[index], map.get(input[index]) + 1);

    for (int i = 0; i < input.length; i++) {
      Integer count = map.get(sum - input[i]);
      if (count != null)
        pairs += count;
      if (sum - input[i] == input[i])
        pairs--;
    }
    return pairs / 2;
  }

  private void validate(int[] input) throws Exception {
    if (input == null || input.length == 0)
      throw new Exception("invalid input");
  }
}
