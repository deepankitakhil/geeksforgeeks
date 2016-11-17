package strings;

/**
 * Created by Deepankit on 11/16/2016.
 */
public class Pangram {
  public static void main(String[] args) {
    Pangram pangram = new Pangram();
    System.out.println(pangram.isPangram("The quick brown fox jumps over the dog"));
  }

  private boolean isPangram(String input) {
    int index;
    input = input.replaceAll(" ", "").toLowerCase();
    boolean[] isCharPresent = new boolean[26];
    for (char inputChar : input.toCharArray())
      isCharPresent[inputChar - 97] = true;
    for (index = 0; index < 26; index++)
      if (isCharPresent[index] == false)
        break;
    if (index == 26)
      return true;
    else
      return false;
  }
}
