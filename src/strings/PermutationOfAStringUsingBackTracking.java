package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepankit on 11/12/2016.
 */
public class PermutationOfAStringUsingBackTracking {
  public static void main(String[] args) {
    PermutationOfAStringUsingBackTracking permutationOfAStringUsingBackTracking = new PermutationOfAStringUsingBackTracking();
    List<String> permutatedList = permutationOfAStringUsingBackTracking.findAllPossiblePermutatedString(new StringBuilder("abc"));
    display(permutatedList);
  }

  private static void display(List<String> permutatedList) {
    for (String str : permutatedList)
      System.out.println(str);
  }

  private List<String> findAllPossiblePermutatedString(StringBuilder input) {
    List<String> permutatedList = new ArrayList<>();
    recursivePermutation(input, permutatedList, 0, input.length() - 1);
    return permutatedList;
  }

  private void swap(StringBuilder input, int firstIndex, int secondIndex) {
    char temp = input.charAt(secondIndex);
    input.setCharAt(secondIndex, input.charAt(firstIndex));
    input.setCharAt(firstIndex, temp);
  }

  private void recursivePermutation(StringBuilder input, List<String> permutatedList, int startIndex, int endIndex) {

    if (startIndex == endIndex)
      permutatedList.add(input.toString());
    else
      for (int index = startIndex; index <= endIndex; index++) {
        swap(input, startIndex, index);
        recursivePermutation(input, permutatedList, startIndex + 1, endIndex);
        swap(input, startIndex, index);
      }
  }
}
