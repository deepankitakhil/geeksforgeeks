package strings;

/**
 * Created by Deepankit on 11/12/2016.
 */
public class NextBiggerString {
  public static void main(String[] args) {
    NextBiggerString nextBiggerString = new NextBiggerString();
    System.out.println(nextBiggerString.findNextBiggerString("1241"));
  }

  private String findNextBiggerString(String input) {
    int index;
    char[] charArray = input.toCharArray();
    index = findElementIndexLesserThanItsRightAdjacent(charArray);
    if (index == -1)
      return input;
    int secondIndex = findNextBiggerElementIndexOnRightSide(charArray, index);
    swap(charArray, index, secondIndex);
    reverseCharArray(charArray, index + 1, charArray.length - 1);
    return new String(charArray);
  }

  private void swap(char[] charArray, int firstIndex, int secondIndex) {
    char temp = charArray[firstIndex];
    charArray[firstIndex] = charArray[secondIndex];
    charArray[secondIndex] = temp;
  }

  private int findNextBiggerElementIndexOnRightSide(char[] charArray, int index) {
    int startIndex;
    int nextLargest = index + 1;
    for (startIndex = nextLargest; startIndex < charArray.length - 1; startIndex++)
      if (charArray[nextLargest] < charArray[startIndex] && charArray[startIndex] > charArray[index])
        nextLargest = startIndex;
    return nextLargest;
  }

  private int findElementIndexLesserThanItsRightAdjacent(char[] charArray) {
    int index;
    for (index = charArray.length - 2; index >= 0; index--)
      if (charArray[index] < charArray[index + 1])
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
