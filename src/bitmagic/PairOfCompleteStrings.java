package bitmagic;

/**
 * Created by Deepankit on 11/15/2016.
 */
public class PairOfCompleteStrings {
  public static void main(String[] args) {
    PairOfCompleteStrings pairOfCompleteStrings = new PairOfCompleteStrings();
    System.out.println(pairOfCompleteStrings.findCountOfCompleteStrings(new String[]{"abcdefgh", "geeksforgeeks",
        "lmnopqrst", "abc"}, new String[]{"ijklmnopqrstuvwxyz",
        "abcdefghijklmnopqrstuvwxyz",
        "defghijklmnopqrstuvwxyz"}));
  }

  private int findCountOfCompleteStrings(String[] firstStrings, String[] secondStrings) {
    int count = 0;
    int index = 0;
    boolean[] isPresent = new boolean[26];
    normalizeInputValues(firstStrings, secondStrings);
    for (String firstString : firstStrings)
      for (String secondString : secondStrings) {
        for (int charIndex = 0; charIndex < firstString.length(); charIndex++) {
          isPresent[firstString.charAt(charIndex) - 97] = true;
        }
        for (int charIndex = 0; charIndex < secondString.length(); charIndex++) {
          isPresent[secondString.charAt(charIndex) - 97] = true;
        }
        for (index = 0; index < 26; index++)
          if (!isPresent[index])
            break;
        if (index == 26)
          count++;
        reset(isPresent);
      }
    return count;
  }

  private void reset(boolean[] isPresent) {
    for (int index = 0; index < 26; index++)
      isPresent[index] = false;
  }

  private void normalizeInputValues(String[] firstStrings, String[] secondStrings) {
    convertToLowerCase(firstStrings);
    convertToLowerCase(secondStrings);
  }

  private void convertToLowerCase(String[] inputStrings) {
    char[] charArray;
    for (int index = 0; index < inputStrings.length; index++) {
      charArray = inputStrings[index].toCharArray();
      for (int charIndex = 0; charIndex < charArray.length; charIndex++) {
        if (charArray[charIndex] >= 65 && charArray[charIndex] <= 91)
          charArray[charIndex] += 32;
      }
      inputStrings[index] = new String(charArray);
    }
  }
}
