package bitmagic;

/**
 * Created by Deepankit on 11/21/2016.
 */
public class AddTwoNumbersWithoutArithmeticOperator {
  public static void main(String[] args) {
    AddTwoNumbersWithoutArithmeticOperator addTwoNumbersWithoutArithmeticOperator = new AddTwoNumbersWithoutArithmeticOperator();
    System.out.println(addTwoNumbersWithoutArithmeticOperator.recursiveAddition(10, 12));
    System.out.println(addTwoNumbersWithoutArithmeticOperator.iterativeAddition(10, 12));
  }

  private int iterativeAddition(int firstInput, int secondInput) {
    int carry;
    while (secondInput != 0) {
      carry = firstInput & secondInput;
      firstInput = firstInput ^ secondInput;
      secondInput = carry << 1;

    }
    return firstInput;
  }

  private int recursiveAddition(int firstInput, int secondInput) {
    if (secondInput == 0)
      return firstInput;
    return recursiveAddition((firstInput ^ secondInput), ((firstInput & secondInput) << 1));
  }
}
