package strings;

import static java.lang.Math.max;

/**
 * Created by Deepankit on 11/8/2016.
 */
public class LongestCommonSubsequence {
  public static void main(String[] args) {
    LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
    int longestSubsequenceLength = longestCommonSubsequence.findLongestSubsequence("XMJYAUZ", "MZJAWXU");
    System.out.println(longestSubsequenceLength);
  }

  private int findLongestSubsequence(String inputOne, String inputTwo) {
    int[][] sequenceSimilarityMapping = new int[inputOne.length() + 1][inputTwo.length() + 1];
    for (int firstIndex = 0; firstIndex < inputOne.length(); firstIndex++) {
      for (int secondIndex = 0; secondIndex < inputTwo.length(); secondIndex++) {
        if (inputOne.charAt(firstIndex) == inputTwo.charAt(secondIndex))
          sequenceSimilarityMapping[firstIndex + 1][secondIndex + 1] = sequenceSimilarityMapping[firstIndex][secondIndex] + 1;
        else
          sequenceSimilarityMapping[firstIndex + 1][secondIndex + 1] =
              max(sequenceSimilarityMapping[firstIndex + 1][secondIndex], sequenceSimilarityMapping[firstIndex][secondIndex + 1]);
      }
    }
    int maxLength = Integer.MIN_VALUE;
    for (int firstIndex = 0; firstIndex <= inputOne.length(); firstIndex++) {
      for (int secondIndex = 0; secondIndex <= inputTwo.length(); secondIndex++) {
        if (maxLength < sequenceSimilarityMapping[firstIndex][secondIndex])
          maxLength = sequenceSimilarityMapping[firstIndex][secondIndex];
      }
    }
    return maxLength;
  }
}
