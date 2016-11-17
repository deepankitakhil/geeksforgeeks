package bitmagic;

/**
 * Created by Deepankit on 11/15/2016.
 */
public class MultipleOfFour {
  public static void main(String[] args) {
    MultipleOfFour multipleOfFour = new MultipleOfFour();
    System.out.println(multipleOfFour.isMultipleOfFour(100));
  }

  private boolean isMultipleOfFour(int input) {
    return (input >> 2) << 2 == input;
  }
}
