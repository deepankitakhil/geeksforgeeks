package miscellaneous;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Deepankit on 11/6/2016.
 */
public class MaxTimeFormationGivenFourIntegers {

  public static void main(String[] args) {
    MaxTimeFormationGivenFourIntegers maxTimeFormationGivenFourIntegers = new MaxTimeFormationGivenFourIntegers();
    String maxPossibleTime = maxTimeFormationGivenFourIntegers.findMaxPossibleTime(2, 3, 1, 6);
    System.out.println(maxPossibleTime);

  }

  public String findMaxPossibleTime(int a, int b, int c, int d) {
    StringBuilder sb = new StringBuilder();
    SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
    sdf.setLenient(false);
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
    sb.append(a).append(b).append(c).append(d);
    Set<String> permutSet = getAllPossiblePermutationsUsingInputString(sb.toString());
    String maxDate = null;
    Date date;
    for (String str : permutSet) {
      try {
        sdf.parse(str);
        if (maxDate == null || maxDate.compareTo(str) < 0) {
          maxDate = str;
        }
      } catch (ParseException ex) {

      }
    }
    if (maxDate == null) {
      return "NOT POSSIBLE";
    } else {
      try {
        date = sdf.parse(maxDate);
        maxDate = sdf1.format(date);
        return maxDate;
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return "NOT POSSIBLE";
  }

  public Set<String> getAllPossiblePermutationsUsingInputString(String input) {
    Set<String> possiblePermutations = new HashSet<>();
    String SPACE = "";
    if (input == SPACE)
      return possiblePermutations;

    Character inputChar = input.charAt(0);

    if (input.length() > 1) {
      input = input.substring(1);

      Set<String> permutations = getAllPossiblePermutationsUsingInputString(input);

      for (String possiblePermutatedString : permutations) {
        for (int index = 0; index <= possiblePermutatedString.length(); index++) {
          possiblePermutations.add(possiblePermutatedString.substring(0, index) + inputChar + possiblePermutatedString.substring(index));
        }
      }
    } else {
      possiblePermutations.add(inputChar + SPACE);
    }
    return possiblePermutations;
  }
}
