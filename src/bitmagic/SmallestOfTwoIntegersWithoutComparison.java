package bitmagic;

/**
 * Created by Deepankit on 11/22/2016.
 */
public class SmallestOfTwoIntegersWithoutComparison {
  public static void main(String[] args) {
    SmallestOfTwoIntegersWithoutComparison smallestOfTwoIntegersWithoutComparison = new SmallestOfTwoIntegersWithoutComparison();
    System.out.println(smallestOfTwoIntegersWithoutComparison.findSmallest(10, 17));
  }

  private int findSmallest(int firstNumber, int secondNumber) {

    double mean = (firstNumber + secondNumber) / 2.0;
    double absoluteDifference = Math.sqrt((firstNumber - secondNumber) * (firstNumber - secondNumber));
    return (int) (mean - absoluteDifference / 2);
  }
}
