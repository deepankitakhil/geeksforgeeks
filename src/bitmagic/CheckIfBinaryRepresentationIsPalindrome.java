package bitmagic;

/**
 * Created by Deepankit on 11/22/2016.
 */
public class CheckIfBinaryRepresentationIsPalindrome {
  public static void main(String[] args) {
    CheckIfBinaryRepresentationIsPalindrome checkIfBinaryRepresentationIsPalindrome = new CheckIfBinaryRepresentationIsPalindrome();
    System.out.println(checkIfBinaryRepresentationIsPalindrome.isPalindrome(6));
  }

  private boolean isPalindrome(int input) {
    int noOfBits = (int) Math.ceil(Math.log(input) / Math.log(2));
    int leftIndex = 1;
    int rightIndex = noOfBits;
    while (leftIndex <= rightIndex) {
      if (findBitAtPosition(input, leftIndex) == findBitAtPosition(input, rightIndex)) {
        leftIndex++;
        rightIndex--;
      } else
        return false;
    }
    return true;
  }

  private int findBitAtPosition(int input, int index) {
    if ((input & (1 << index - 1)) == 0)
      return 0;
    else
      return 1;
  }

}
