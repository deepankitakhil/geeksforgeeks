package bitmagic;

/**
 * Created by Deepankit on 11/22/2016.
 */
public class TurnOffParticularBitInAGivenNumber {
  public static void main(String[] args) {
    TurnOffParticularBitInAGivenNumber turnOffParticularBitInAGivenNumber = new TurnOffParticularBitInAGivenNumber();
    System.out.println(turnOffParticularBitInAGivenNumber.turnOffParticularBit(15, 5));
  }

  private long turnOffParticularBit(long input, int position) {
    long temp = 1 << position - 1;
    return input & ~temp;
  }
}
