package numbers;

/**
 * Created by deepankit on 12/8/2016.
 */
public class PascalTriangle {
  public static void main(String[] args) {
    PascalTriangle pascalTriangle = new PascalTriangle();
    pascalTriangle.findNthPascalValue(5);

  }

  private int findNthPascalValue(int input) {
    int sum = 0;
    int k = 0;
    while (input >= k) {
      System.out.print(calculateCombination(input, k) + "  ");
      k++;
    }
    return sum;
  }

  private int calculateCombination(int input, int k) {
    return factorial(input) / (factorial(k) * factorial(input - k));
  }

  private int factorial(int input) {
    int product = 1;
    for (int index = 1; index <= input; index++)
      product *= index;
    return product;
  }
}
