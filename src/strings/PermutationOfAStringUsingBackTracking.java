package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepankit on 11/12/2016.
 */
public class PermutationOfAStringUsingBackTracking {
  public static void main(String[] args) {
    PermutationOfAStringUsingBackTracking permutationOfAStringUsingBackTracking = new PermutationOfAStringUsingBackTracking();
    List<String> permutedList = permutationOfAStringUsingBackTracking.findAllPossiblePermutedString(new StringBuilder("abc"));
    display(permutedList);
  }

  private static void display(List<String> permutedList) {
    for (String str : permutedList)
      System.out.println(str);
  }

  private List<String> findAllPossiblePermutedString(StringBuilder input) {
    List<String> permutedList = new ArrayList<>();
    recursivePermutation(input, permutedList, 0, input.length() - 1);
    return permutedList;
  }

  private void swap(StringBuilder input, int firstIndex, int secondIndex) {
    char temp = input.charAt(secondIndex);
    input.setCharAt(secondIndex, input.charAt(firstIndex));
    input.setCharAt(firstIndex, temp);
  }

  private void recursivePermutation(StringBuilder input, List<String> permutedList, int startIndex, int endIndex) {

    if (startIndex == endIndex)
      permutedList.add(input.toString());
    else
      for (int index = startIndex; index <= endIndex; index++) {
        swap(input, startIndex, index);
        recursivePermutation(input, permutedList, startIndex + 1, endIndex);
        swap(input, startIndex, index);
      }
  }
}
