package strings;

/**
 * Created by deepankit on 12/9/2016.
 */
public class MergeString {
  public static void main(String[] args) {
    MergeString mergeString = new MergeString();
    System.out.println(mergeString.mergeStrings("", ""));
  }

  private String mergeStrings(String a, String b) {
    StringBuilder output = new StringBuilder();
    int minLength = a.length() > b.length() ? b.length() : a.length();
    int index;
    for (index = 0; index < minLength; index++) {
      output.append(a.charAt(index)).append(b.charAt(index));
    }
    while (index < a.length()) {
      output.append(a.charAt(index));
      index++;
    }

    while (index < b.length()) {
      output.append(b.charAt(index));
      index++;
    }
    return output.toString();
  }
}
