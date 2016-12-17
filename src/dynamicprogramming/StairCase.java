package dynamicprogramming;

/**
 * Created by deepankit on 12/9/2016.
 */
public class StairCase {
  public static void main(String[] args) {
    StairCase stairCase = new StairCase();
    System.out.println(stairCase.findTotalWaysToReachOnTop(3));
  }

  private long findTotalWaysToReachOnTop(int input) {
    long[] output = new long[input + 1];
    output[1] = 1;
    output[2] = 2;
    output[3] = 4;

    for (int j = 4; j <= input; j++)
      output[j] = output[j - 1] + output[j - 2] + output[j - 3];

    return output[input];
  }
}
