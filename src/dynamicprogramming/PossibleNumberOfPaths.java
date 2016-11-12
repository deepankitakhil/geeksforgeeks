package dynamicprogramming;

/**
 * Created by Deepankit on 11/11/2016.
 */
public class PossibleNumberOfPaths {
  public static void main(String[] args) {
    PossibleNumberOfPaths possibleNumberOfPaths = new PossibleNumberOfPaths();
    int rowLength = 2;
    int columnLength = 3;
    System.out.println(possibleNumberOfPaths.findPossibleNumberOfPaths(rowLength, columnLength));
  }

  private int findPossibleNumberOfPaths(int rowLength, int columnLength) {
    int[][] possiblePathCount = new int[rowLength][columnLength];

    for (int index = 0; index < rowLength; index++)
      possiblePathCount[index][0] = 1;
    for (int index = 0; index < columnLength; index++)
      possiblePathCount[0][index] = 1;

    for (int firstIndex = 1; firstIndex < rowLength; firstIndex++)
      for (int secondIndex = 1; secondIndex < columnLength; secondIndex++) {
        possiblePathCount[firstIndex][secondIndex] = possiblePathCount[firstIndex - 1][secondIndex] + possiblePathCount[firstIndex][secondIndex - 1] +
            possiblePathCount[firstIndex - 1][secondIndex - 1];
      }
    return possiblePathCount[rowLength - 1][columnLength - 1];
  }
}
