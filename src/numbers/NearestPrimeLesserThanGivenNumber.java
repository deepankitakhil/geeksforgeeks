package numbers;

/**
 * Created by Deepankit on 11/13/2016.
 */
public class NearestPrimeLesserThanGivenNumber {
  public static void main(String[] args) {
    NearestPrimeLesserThanGivenNumber nearestPrimeLesserThanGivenNumber = new NearestPrimeLesserThanGivenNumber();
    System.out.println(nearestPrimeLesserThanGivenNumber.findNearestPrime(5));
  }

  private int findNearestPrime(int input) {
    if (input <= 5)
      return 3;

    for (int number = input - 1; number > input - 6; number--)
      if ((number - 1) % 6 == 0 || (number + 1) % 6 == 0)
        return number;
    return Integer.MIN_VALUE;
  }
}
