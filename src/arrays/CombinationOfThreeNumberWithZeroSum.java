package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deepankit on 12/12/2016.
 */
public class CombinationOfThreeNumberWithZeroSum {
  public static void main(String[] args) {
    CombinationOfThreeNumberWithZeroSum combinationOfThreeNumberWithZeroSum = new CombinationOfThreeNumberWithZeroSum();

    int[] input = new int[]{2, 3, 1, -2, -1, 0, 2, -3, 0};
    combinationOfThreeNumberWithZeroSum.groupSameSignNumbers(input);
    System.out.println(combinationOfThreeNumberWithZeroSum.findCombination(input));
  }

  private int findCombination(int[] input) {

    Map<Integer, Integer> countMap = new HashMap<>();
    int pairs = 0;
    int indexOfLastNegativeNumber = findIndexOfLastNegativeNumber(input);

    for (int index = indexOfLastNegativeNumber + 1; index < input.length; index++) {
      if (countMap.containsKey(input[index]))
        countMap.put(input[index], countMap.get(input[index]) + 1);
      else
        countMap.put(input[index], 1);
    }

    for (int index = 0; index <= indexOfLastNegativeNumber; index++) {
      int sum = input[index];
      pairs += findPairsWithGivenSum(input, countMap, sum);
    }
    return pairs;
  }

  private int findPairsWithGivenSum(int[] input, Map<Integer, Integer> countMap, int sum) {
    int pairs = 0;
    for (int index = 0; index < input.length; index++) {
      Integer count = countMap.get(Math.abs(input[index] + sum));
      if (count != null) {
        pairs += count;
        System.out.println("Combinations : " + input[index] + "," + Math.abs(input[index] + sum) + "," + sum);
        if (Math.abs(input[index] + sum) == input[index])
          pairs--;
      }
    }
    return pairs;
  }

  private int findIndexOfLastNegativeNumber(int[] input) {
    return binarySearchForIdentifyingLastNegativeNumberIndex(input, 0, input.length);
  }

  private int binarySearchForIdentifyingLastNegativeNumberIndex(int[] input, int firstIndex, int secondIndex) {
    if (firstIndex < secondIndex) {
      int midIndex = firstIndex + (secondIndex - firstIndex) / 2;
      if (input[midIndex] < 0)
        if (input[midIndex + 1] > 0)
          return midIndex;
        else
          return binarySearchForIdentifyingLastNegativeNumberIndex(input, midIndex, secondIndex);
      else {
        return binarySearchForIdentifyingLastNegativeNumberIndex(input, firstIndex, midIndex);
      }
    }
    return Integer.MIN_VALUE;
  }

  private void groupSameSignNumbers(int[] input) {
    int negativeNumberIndex = 0;
    int length = input.length;
    int positiveNumberIndex = length - 1;
    while (negativeNumberIndex <= positiveNumberIndex) {
      if (input[negativeNumberIndex] < 0 && input[positiveNumberIndex] < 0)
        negativeNumberIndex++;
      else if (input[negativeNumberIndex] > 0 && input[positiveNumberIndex] >= 0)
        positiveNumberIndex--;
      else if (input[negativeNumberIndex] > 0 && input[positiveNumberIndex] < 0) {
        swap(input, negativeNumberIndex, positiveNumberIndex);
        negativeNumberIndex++;
        positiveNumberIndex--;
      } else if (input[negativeNumberIndex] < 0 && input[positiveNumberIndex] >= 0) {
        negativeNumberIndex++;
        positiveNumberIndex--;
      }
    }
  }

  private void swap(int[] input, int firstIndex, int secondIndex) {
    int temp = input[firstIndex];
    input[firstIndex] = input[secondIndex];
    input[secondIndex] = temp;
  }
}
