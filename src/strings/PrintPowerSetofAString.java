package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Deepankit on 10/19/2016.
 */
public class PrintPowerSetofAString {
  public static void main(String[] args) {
    PrintPowerSetofAString printPowerSetofAString = new PrintPowerSetofAString();
    String[] allSubString = printPowerSetofAString.buildSubsequences("gfg");
    printPowerSetofAString.display(allSubString);
  }

  private void display(String[] allSubString) {
    for (int index = 0; index < allSubString.length; index++)
      System.out.println(allSubString[index]);
  }

  public static String[] buildSubsequences(String s) {
    List<String> output = new ArrayList<>();
    for (int index = 0; index < s.length(); index++) {
      for (String subString : subStrings(s.substring(index + 1))) {
        output.add(s.charAt(index) + subString);
      }
    }
    Collections.sort(output);

    String[] temp = new String[output.size()];
    for (int index = 0; index < output.size(); index++)
      temp[index] = output.get(index);
    return temp;
  }

  public static List<String> subStrings(String input) {
    ArrayList<String> strings = new ArrayList<>();
    strings.add("");
    for (int firstIndex = 0; firstIndex < input.length(); firstIndex++) {
      for (int secondIndex = firstIndex + 1; secondIndex < input.length() + 1; secondIndex++)
        strings.add(input.substring(firstIndex, secondIndex));
    }

    return strings;
  }
}
