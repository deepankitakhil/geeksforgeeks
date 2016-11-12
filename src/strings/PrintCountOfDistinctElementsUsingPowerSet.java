package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Deepankit on 11/11/2016.
 */
public class PrintCountOfDistinctElementsUsingPowerSet {
  public static void main(String[] args) {
    PrintCountOfDistinctElementsUsingPowerSet printCountOfDistinctElementsUsingPowerSet = new PrintCountOfDistinctElementsUsingPowerSet();
    printCountOfDistinctElementsUsingPowerSet.findDistinctElementsInPowerSet("abc");
  }

  private void findDistinctElementsInPowerSet(String input) {
    Set<String> powerSetList = new HashSet<>();
    powerSetList.add("");
    for (int index = 0; index < input.length(); index++) {
      Set<String> possibleSubSequence = findAllPossibleSubSequence(input.substring(index + 1));
      for (String subString : possibleSubSequence)
        powerSetList.add(input.charAt(index) + subString);
    }
    System.out.println(powerSetList.size());
  }

  private Set<String> findAllPossibleSubSequence(String substring) {
    Set<String> possibleSubStrings = new HashSet<>();
    possibleSubStrings.add("");
    for (int firstIndex = 0; firstIndex < substring.length(); firstIndex++)
      for (int secondIndex = firstIndex + 1; secondIndex < substring.length() + 1; secondIndex++) {
        possibleSubStrings.add(substring.substring(firstIndex, secondIndex));
      }
    return possibleSubStrings;
  }
}
