package arrays;

/**
 * Created by Deepankit on 11/15/2016.
 */
public class BalancePointInAnArray {
  public static void main(String[] args) {
    BalancePointInAnArray balancePointInAnArray = new BalancePointInAnArray();
    System.out.println(balancePointInAnArray.findBalancePoint(new int[]{2, 7, 4, 5, -3, 8, 9, -1}));
  }

  private int findBalancePoint(int[] input) {
    int leftSum = 0;
    int rightSum = input[0];
    for (int index = 0; index < input.length; index++)
      leftSum += input[index];

    for (int index = 0; index < input.length; index++) {
      if (leftSum == rightSum)
        return index;
      else
        leftSum -= input[index];
      rightSum += input[index + 1];
    }
    return Integer.MIN_VALUE;
  }
}
