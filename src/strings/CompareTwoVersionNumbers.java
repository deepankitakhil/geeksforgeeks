package strings;

/**
 * Created by Deepankit on 11/16/2016.
 */
public class CompareTwoVersionNumbers {
  public static void main(String[] args) {
    CompareTwoVersionNumbers compareTwoVersionNumbers = new CompareTwoVersionNumbers();
    System.out.println(compareTwoVersionNumbers.compare("1.0.7.1", "1.0.7"));
  }

  private String compare(String firstVersion, String secondVersion) {
    if (firstVersion.replaceAll("\\.", "").compareTo(secondVersion.replaceAll("\\.", "")) > 0)
      return firstVersion;
    else
      return secondVersion;
  }
}
