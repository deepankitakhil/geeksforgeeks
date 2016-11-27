package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Deepankit on 11/16/2016.
 */
public class GroupShiftedStrings {
  public static void main(String[] args) {
    GroupShiftedStrings groupShiftedStrings = new GroupShiftedStrings();
    Map<String, Set<String>> shiftedStrings = groupShiftedStrings.findGroupShiftedStrings(new String[]{"acd", "dfg", "wyz", "yab", "mop",
        "bdfh", "a", "x", "moqs"});
    groupShiftedStrings.display(shiftedStrings);
  }

  private void display(Map<String, Set<String>> shiftedStrings) {
    for (Map.Entry<String, Set<String>> entry : shiftedStrings.entrySet())
      System.out.println(entry.getValue());
  }

  private Map<String, Set<String>> findGroupShiftedStrings(String[] inputArray) {
    Map<String, Set<String>> result = new HashMap<>();
    String key;
    Set<String> groupShiftedString;
    for (String input : inputArray) {
      key = "";
      for (int index = 0; index < input.length() - 1; index++) {
        int charDifference = input.charAt(index + 1) - input.charAt(index);
        charDifference = charDifference < 0 ? 26 + charDifference : charDifference;
        key += charDifference;
      }
      if (result.containsKey(key)) {
        groupShiftedString = result.get(key);
        groupShiftedString.add(input);
        result.put(key, groupShiftedString);
      } else {
        groupShiftedString = new HashSet<>();
        groupShiftedString.add(input);
        result.put(key, groupShiftedString);
      }
    }
    return result;
  }
}
