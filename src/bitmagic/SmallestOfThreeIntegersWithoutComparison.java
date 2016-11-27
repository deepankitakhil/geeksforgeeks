package bitmagic;

/**
 * Created by Deepankit on 11/22/2016.
 */
public class SmallestOfThreeIntegersWithoutComparison {
  public static void main(String[] args) {
    SmallestOfThreeIntegersWithoutComparison smallestOfThreeIntegersWithoutComparison = new SmallestOfThreeIntegersWithoutComparison();
    System.out.println(smallestOfThreeIntegersWithoutComparison.findSmallest(10, 15, 13));
  }

  private int findSmallest(int firstInput, int secondInput, int thirdInput) {
    return findSmallest(findSmallest(firstInput, secondInput), thirdInput);
  }


  private int findSmallest(int firstNumber, int secondNumber) {

    double mean = (firstNumber + secondNumber) / 2.0;
    double absoluteDifference = Math.sqrt((firstNumber - secondNumber) * (firstNumber - secondNumber));
    return (int) (mean - absoluteDifference / 2);
  }
}
