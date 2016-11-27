package bitmagic;

/**
 * Created by Deepankit on 11/22/2016.
 */
public class BooleanArrayTwoElementsMakeAllElementZero {
  public static void main(String[] args) {
    BooleanArrayTwoElementsMakeAllElementZero booleanArrayTwoElementsMakeAllElementZero = new BooleanArrayTwoElementsMakeAllElementZero();
    int[] input = {1, 0};
    booleanArrayTwoElementsMakeAllElementZero.convertElementWithValueOneToZero(input);
    System.out.println(input[0]);
    System.out.println(input[1]);
  }

  private void convertElementWithValueOneToZero(int[] input) {
    input[input[1]] = input[input[0]];
  }
}
