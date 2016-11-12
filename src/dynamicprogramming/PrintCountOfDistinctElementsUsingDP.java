package dynamicprogramming;

/**
 * Created by Deepankit on 11/11/2016.
 */
public class PrintCountOfDistinctElementsUsingDP {
  public static void main(String[] args) {
    PrintCountOfDistinctElementsUsingDP printCountOfDistinctElementsUsingDP = new PrintCountOfDistinctElementsUsingDP();
    System.out.println(printCountOfDistinctElementsUsingDP.findCountOfDistinctSubSequence("gfg"));
  }

  private int findCountOfDistinctSubSequence(String input) {
    int[] alphabetIndex = new int[256];
    int[] distinctElementsCount = new int[input.length() + 1];
    for (int index = 0; index < 256; index++)
      alphabetIndex[index] = -1;
    distinctElementsCount[0] = 1;
    for (int index = 1; index <= input.length(); index++) {
      distinctElementsCount[index] = 2 * distinctElementsCount[index - 1];
      if (alphabetIndex[input.charAt(index - 1)] != -1)
        distinctElementsCount[index] = distinctElementsCount[index] - distinctElementsCount[alphabetIndex[input.charAt(index - 1)]];
      alphabetIndex[input.charAt(index - 1)] = index - 1;

    }
    return distinctElementsCount[input.length()];
  }
}
