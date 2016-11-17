package bitmagic;

/**
 * Created by Deepankit on 11/16/2016.
 */
public class BitwiseAndOrInARange {
  public static void main(String[] args) {
    BitwiseAndOrInARange bitwiseAndOrInARange = new BitwiseAndOrInARange();
    System.out.println(bitwiseAndOrInARange.findBitwsieAndOfAllElementsInRange(10, 20));
  }

  private int findBitwsieAndOfAllElementsInRange(int firstNumber, int secondNumber) {
    int result = 0;
    int difference;
    while ((firstNumber & secondNumber) != 0) {
      int mostSignificantBitsForFirstNumber = findMostSignificantBits(firstNumber);
      int mostSignificantBitsForSecondNumber = findMostSignificantBits(secondNumber);
      if (mostSignificantBitsForFirstNumber != mostSignificantBitsForSecondNumber)
        break;
      difference = 1 << mostSignificantBitsForFirstNumber;
      result += difference;
      firstNumber -= difference;
      secondNumber -= difference;
    }
    return result;
  }

  private int findMostSignificantBits(int number) {
    int mostSignificantBit = 0;
    while (number > 0) {
      number = number >> 1;
      mostSignificantBit++;
    }
    return mostSignificantBit - 1;
  }

}
