package bitmagic;

/**
 * Created by Deepankit on 11/17/2016.
 */
public class DetectNumberWithDifferentSign {
  public static void main(String[] args) {
    DetectNumberWithDifferentSign detectNumberWithDifferentSign = new DetectNumberWithDifferentSign();
    System.out.println(detectNumberWithDifferentSign.areDifferentSignedNumbers(10, -10));
  }

  private boolean areDifferentSignedNumbers(int firstnumber, int secondNumber) {
    return (firstnumber ^ secondNumber) < 0;
  }
}
