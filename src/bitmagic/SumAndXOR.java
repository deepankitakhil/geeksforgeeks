package bitmagic;

/**
 * Created by Deepankit on 11/16/2016.
 */
public class SumAndXOR {
  public static void main(String[] args) {
    SumAndXOR sumAndXOR = new SumAndXOR();
    System.out.println(sumAndXOR.findCountOfPositiveIntegers(7));
  }

  private int findCountOfPositiveIntegers(int input) {
    int count = 0;
    while (input > 0) {
      if ((input & 1) == 0)
        count++;
      input = input >> 1;
    }
    return (int) Math.pow(2, count);
  }
}
