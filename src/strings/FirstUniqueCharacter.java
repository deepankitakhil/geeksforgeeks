package strings;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Deepankit on 11/15/2016.
 */
public class FirstUniqueCharacter {
  public static void main(String[] args) {
    FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
    System.out.println(firstUniqueCharacter.findFirstUniqueCharacter("geeksforgeeks"));
  }

  private String findFirstUniqueCharacter(String input) {

    Map<Character, Integer> countMap = new LinkedHashMap();
    if (input == null || input.length() == 0)
      return "";
    else {
      for (char character : input.toCharArray())
        if (countMap.containsKey(character))
          countMap.put(character, countMap.get(character) + 1);
        else
          countMap.put(character, 1);

      Iterator<Map.Entry<Character, Integer>> iterator = countMap.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry<Character, Integer> next = iterator.next();
        if (next.getValue() == 1)
          return "" + next.getKey();

      }
    }
    return null;
  }
}
