package arrays;

import static java.lang.Math.min;

/**
 * Created by Deepankit on 11/7/2016.
 */
public class LongestSubarrayWithVaueLessThanOrEqualToGivenValue {
  public static void main(String[] args) {
    LongestSubarrayWithVaueLessThanOrEqualToGivenValue longestSubarrayWithVaueLessThanOrEqualToGivenValue = new LongestSubarrayWithVaueLessThanOrEqualToGivenValue();
    int[] input = new int[]{};
    int threshold = 10;
    longestSubarrayWithVaueLessThanOrEqualToGivenValue.findLongestSubarray(input, threshold);
  }

  private int findLongestSubarray(int[] input, int threshold) {
    int[] prefixSum = new int[input.length];
    int sum = 0;
    for (int index = 0; index < input.length; index++) {
      sum += input[index];
      prefixSum[index] = sum;
    }

    if (prefixSum[input.length - 1] <= threshold) {
      return input.length;
    }

    int[] minimumPrefixSum = new int[prefixSum.length];
    for (int index = minimumPrefixSum.length - 2; index >= 0; index--)
      minimumPrefixSum[index] = min(minimumPrefixSum[index], minimumPrefixSum[index + 1]);


    int firstIndex = 0, secondIndex = 0, maxLength = 0;
    while (firstIndex < input.length && secondIndex < input.length) {
      int minCurrSum = firstIndex > 0 ? minimumPrefixSum[secondIndex] - prefixSum[firstIndex - 1]
          : minimumPrefixSum[secondIndex];
      if (minCurrSum <= threshold) {
        int currLength = secondIndex - firstIndex + 1;
        if (currLength > maxLength) {
          maxLength = currLength;
        }
        ++secondIndex;
      } else {
        ++firstIndex;
      }
    }
    return maxLength;
  }
}
