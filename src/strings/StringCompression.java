package strings;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by deepankit on 12/9/2016.
 */
public class StringCompression {

  public static void main(String[] args) {
    StringCompression stringCompression = new StringCompression();
    System.out.println(stringCompression.runLengthEncode(""));
  }


  private String runLengthEncode(String input) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (char c : input.toCharArray()) {
      if (map.containsKey(c))
        map.put(c, map.get(c) + 1);
      else
        map.put(c, 1);
    }
    StringBuilder output = new StringBuilder();
    Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Character, Integer> next = iterator.next();

      output.append(next.getValue()).append(next.getKey());
    }
    return output.toString();
  }
}
