package numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Deepankit on 11/9/2016.
 */
public class DistinctNumbersInARange {
  public static void main(String[] args) {
    DistinctNumbersInARange distinctNumbersInARange = new DistinctNumbersInARange();
    int input = 130;
    List<Integer> distinctDigits = distinctNumbersInARange.findNumbersWithDistinctDigits(input);
    distinctNumbersInARange.display(distinctDigits);
  }

  private void display(List<Integer> distinctDigits) {
    for (Integer digit : distinctDigits)
      System.out.println(digit);
  }

  private List<Integer> findNumbersWithDistinctDigits(int input) {
    List<Integer> numbersWithDistinctDigits = new ArrayList<>();

    for (int number = 1; number <= input; number++) {
      if (areUniqueDigits(number))
        numbersWithDistinctDigits.add(number);
    }
    return numbersWithDistinctDigits;
  }

  private boolean areUniqueDigits(int number) {
    int count = 0;
    Set<Integer> distinctNumbers = new HashSet<>();
    while (number > 0) {
      distinctNumbers.add(number - number / 10 * 10);
      count++;
      number = number / 10;
    }
    return count == distinctNumbers.size();
  }
}
