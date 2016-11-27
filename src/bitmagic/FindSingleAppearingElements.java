package bitmagic;

/**
 * Created by Deepankit on 11/17/2016.
 */
public class FindSingleAppearingElements {
  public static void main(String[] args) {
    FindSingleAppearingElements findSingleAppearingElements = new FindSingleAppearingElements();
    System.out.println(findSingleAppearingElements.findSingleAppearedElement(new int[]{12, 1, 12, 3, 12, 1, 1, 2, 3, 3}));
  }

  private int findSingleAppearedElement(int[] input) {
    int appearedOnce = 0;
    int appearedTwice = 0;
    int appearedThrice = 0;

    for (int index = 0; index < input.length; index++) {
      appearedTwice = appearedTwice | appearedOnce & input[index];
      appearedOnce = appearedOnce ^ input[index];
      appearedThrice = appearedOnce & appearedTwice;
      appearedOnce = ~appearedThrice & appearedOnce;
      appearedTwice = ~appearedThrice & appearedTwice;
    }
    return appearedOnce;
  }
}
