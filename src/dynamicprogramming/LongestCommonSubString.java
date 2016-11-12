package dynamicprogramming;

/**
 * Created by Deepankit on 11/6/2016.
 */
public class LongestCommonSubString {
  public static void main(String[] args) {
    LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
    String commonSubString = longestCommonSubString.findLongestCommonSubString("BABC", "ABCBA");
    System.out.println(commonSubString);
  }

  private String findLongestCommonSubString(String firstString, String secondString) {
    int maxSubStringLength = Integer.MIN_VALUE;
    int startIndex = Integer.MIN_VALUE;
    int[][] matchedCharArrayCount = new int[firstString.length() + 1][secondString.length() + 1];
    for (int firstIndex = 0; firstIndex < firstString.length(); firstIndex++)
      for (int secondIndex = 0; secondIndex < secondString.length(); secondIndex++) {
        if (firstString.charAt(firstIndex) == secondString.charAt(secondIndex))
          matchedCharArrayCount[firstIndex + 1][secondIndex + 1] = matchedCharArrayCount[firstIndex][secondIndex] + 1;
      }
    for (int firstIndex = 0; firstIndex < firstString.length() + 1; firstIndex++)
      for (int secondIndex = 0; secondIndex < secondString.length(); secondIndex++) {
        if (maxSubStringLength < matchedCharArrayCount[firstIndex][secondIndex]) {
          maxSubStringLength = matchedCharArrayCount[firstIndex][secondIndex];
          startIndex = firstIndex;
        }
      }
    System.out.println(maxSubStringLength);
    return firstString.substring(startIndex - maxSubStringLength, startIndex);
  }
}
