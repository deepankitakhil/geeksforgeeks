package bitmagic;

/**
 * Created by Deepankit on 11/22/2016.
 */
public class SwapNibblesInAByte {
  public static void main(String[] args) {
    SwapNibblesInAByte swapNibblesInAByte = new SwapNibblesInAByte();
    System.out.println(swapNibblesInAByte.swap(100));
  }

  private int swap(int input) {
    int firstNibbleSet = (input & 15) << 4;
    int secondNibbleSet = (input & 240) >> 4;
    return (firstNibbleSet | secondNibbleSet);
  }
}
