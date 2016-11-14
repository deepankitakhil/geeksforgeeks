package strings;

/**
 * Created by Deepankit on 11/13/2016.
 */
public class PreviousSmallerString {
  public static void main(String[] args) {
    PreviousSmallerString previousSmallerString = new PreviousSmallerString();
    System.out.println(previousSmallerString.findPriviousSmallerString("536479"));
  }

  private String findPriviousSmallerString(String input) {
    int index;
    char[] charArray = input.toCharArray();
    index = findElementIndexGreaterThanItsRightAdjacent(charArray);
    if (index == -1)
      return input;
    int secondIndex = findNextSmallerElementIndexOnRightSide(charArray, index);
    swap(charArray, index, secondIndex);
    reverseCharArray(charArray, index + 1, charArray.length - 1);
    return new String(charArray);
  }

  private void swap(char[] charArray, int firstIndex, int secondIndex) {
    char temp = charArray[firstIndex];
    charArray[firstIndex] = charArray[secondIndex];
    charArray[secondIndex] = temp;
  }

  private int findNextSmallerElementIndexOnRightSide(char[] charArray, int index) {
    int startIndex;
    int nextSmallest = index + 1;
    for (startIndex = nextSmallest; startIndex < charArray.length - 1; startIndex++)
      if (charArray[nextSmallest] > charArray[startIndex] && charArray[startIndex] > charArray[index])
        nextSmallest = startIndex;
    return nextSmallest;
  }

  private int findElementIndexGreaterThanItsRightAdjacent(char[] charArray) {
    int index;
    for (index = charArray.length - 2; index >= 0; index--)
      if (charArray[index] > charArray[index + 1])
        break;
    return index;
  }

  private void reverseCharArray(char[] array, int startIndex, int endIndex) {
    char temp;
    for (int index = 0; index <= (endIndex - startIndex) / 2; index++) {
      temp = array[index + startIndex];
      array[index + startIndex] = array[endIndex - index];
      array[endIndex - index] = temp;
    }
  }
}
