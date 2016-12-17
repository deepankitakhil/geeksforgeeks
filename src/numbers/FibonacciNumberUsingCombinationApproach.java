package numbers;

/**
 * Created by deepankit on 12/8/2016.
 */
public class FibonacciNumberUsingCombinationApproach {
  public static void main(String[] args) {
    FibonacciNumberUsingCombinationApproach fibonacciNumberUsingCombinationApproach = new FibonacciNumberUsingCombinationApproach();
    System.out.println(fibonacciNumberUsingCombinationApproach.findFibonacciNumber(9));
  }

  private int findFibonacciNumber(int input) {
    int sum = 0;
    int k = 0;
    input = input - 2;
    while (input >= k) {
      sum += calculateCombination(input, k);
      input--;
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
