package dynamicprogramming;

/**
 * Created by Deepankit on 11/6/2016.
 */
public class LongestCommonPalindromeSubString {
  public static void main(String[] args) {
    LongestCommonPalindromeSubString longestCommonPalindromeSubString = new LongestCommonPalindromeSubString();
    longestCommonPalindromeSubString.longestCommonPalindromeSubSequence("bdbbbbdbb");
  }

  private int longestCommonPalindromeSubSequence(String input) {

    String longestPalindrome = input.substring(0, 1);
    int leftMostIndex;
    int rightMostIndex;
    int inputLength = input.length();

    for (int index = 0; index < inputLength; index++) {

      leftMostIndex = index - 1;
      rightMostIndex = index;
      String longestPalindromeSequence = getLongestPalindormeString(input, leftMostIndex, rightMostIndex, inputLength);
      if (longestPalindrome.length() < longestPalindromeSequence.length())
        longestPalindrome = longestPalindromeSequence;

      leftMostIndex = index - 1;
      rightMostIndex = index + 1;
      longestPalindromeSequence = getLongestPalindormeString(input, leftMostIndex, rightMostIndex, inputLength);
      if (longestPalindrome.length() < longestPalindromeSequence.length())
        longestPalindrome = longestPalindromeSequence;

    }
    System.out.println(longestPalindrome);
    return longestPalindrome.length();
  }

  private String getLongestPalindormeString(String input, int leftMostIndex, int rightMostIndex, int inputLength) {
    while (leftMostIndex >= 0 && rightMostIndex < inputLength && input.charAt(leftMostIndex) == input.charAt(rightMostIndex)) {
      leftMostIndex--;
      rightMostIndex++;
    }
    return input.substring(leftMostIndex + 1, rightMostIndex);
  }
}
