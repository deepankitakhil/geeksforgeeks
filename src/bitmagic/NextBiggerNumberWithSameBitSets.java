package bitmagic;

/**
 * Created by Deepankit on 11/22/2016.
 */
public class NextBiggerNumberWithSameBitSets {
  public static void main(String[] args) {
    NextBiggerNumberWithSameBitSets nextBiggerNumberWithSameBitSets = new NextBiggerNumberWithSameBitSets();
    System.out.println(nextBiggerNumberWithSameBitSets.findNextBiggerElement(10));
  }

  private int findNextBiggerElement(int input) {
    int K1 = input & -input;
    int M = input + K1;
    int K2 = M & -M;
    return K2 + ((K2/K1)>>1) - 1;

  }
}
