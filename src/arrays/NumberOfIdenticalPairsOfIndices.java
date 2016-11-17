package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deepankit on 11/15/2016.
 */
public class NumberOfIdenticalPairsOfIndices {
  public static void main(String[] args) {
    NumberOfIdenticalPairsOfIndices numberOfIdenticalPairsOfIndices = new NumberOfIdenticalPairsOfIndices();
    System.out.println(numberOfIdenticalPairsOfIndices.findIdenticalPairs(new int[]{3, 5, 6, 3, 3, 5}));
  }

  private int findIdenticalPairs(int[] input) {
    int noOfPairs = 0;
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int index = 0; index < input.length; index++) {
      if (countMap.get(input[index]) == null)
        countMap.put(input[index], 1);
      else {
        noOfPairs += countMap.put(input[index], countMap.get(input[index]) + 1);
      }
    }
    return noOfPairs;
  }
}
