package dynamicprogramming;

/**
 * Created by Deepankit on 11/6/2016.
 */
public class RecursiveLongestCommonPalindrome {
  public static void main(String[] args) {
    RecursiveLongestCommonPalindrome recursiveLongestCommonPalindrome = new RecursiveLongestCommonPalindrome();
    String inputString = "BBABCBCAB";
    int commonPalindrome = recursiveLongestCommonPalindrome.findLongestCommonPalindrome(inputString, 0, inputString.length() - 1);
    System.out.println(commonPalindrome);
  }

  private int findLongestCommonPalindrome(String inputString, int startIndex, int endIndex) {
    if (startIndex == endIndex)
      return 1;
    if (inputString.charAt(startIndex) == inputString.charAt(endIndex) && (startIndex + 1 == endIndex))
      return 2;
    if (inputString.charAt(startIndex) == inputString.charAt(endIndex))
      return 2 + findLongestCommonPalindrome(inputString, startIndex + 1, endIndex - 1);
    else {
      return Math.max(findLongestCommonPalindrome(inputString, startIndex, endIndex - 1),
          findLongestCommonPalindrome(inputString, startIndex + 1, endIndex));
    }
  }
}