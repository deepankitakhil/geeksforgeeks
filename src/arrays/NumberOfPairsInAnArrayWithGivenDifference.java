package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Deepankit on 10/13/2016.
 */
public class NumberOfPairsInAnArrayWithGivenDifference {
  public static void main(String[] args) throws Exception {
    NumberOfPairsInAnArrayWithGivenDifference numberOfPairsInAnArrayWithGivenDifference = new NumberOfPairsInAnArrayWithGivenDifference();
    int[] input = new int[]{8, 12, 16, 4, 0, 20};
    int difference = 4;
    numberOfPairsInAnArrayWithGivenDifference.validate(input);
    System.out.println(numberOfPairsInAnArrayWithGivenDifference.findNumberOfPairs(input, difference));
  }

  private int findNumberOfPairs(int[] input, int difference) {
    int count = 0;
    Set<Integer> sumOfDifferenceWithInputElement = new HashSet<>();
    for (int index = 0; index < input.length; index++)
      sumOfDifferenceWithInputElement.add(input[index]);

    for (int index = 0; index < input.length; index++) {
      if (sumOfDifferenceWithInputElement.contains(difference + input[index]))
        count++;
      if (sumOfDifferenceWithInputElement.contains(Math.abs(difference - input[index])))
        count++;
      sumOfDifferenceWithInputElement.remove(input[index]);
    }
    return count;
  }


  private void validate(int[] input) throws Exception {
    if (input == null || input.length == 0)
      throw new Exception("invalid input");
  }
}
