package sort;

/**
 * Created by Deepankit on 11/08/2016.
 */
public class MinimumLengthUnsortedArray {
  public static void main(String[] args) {
    MinimumLengthUnsortedArray minimumLengthUnsortedArray = new MinimumLengthUnsortedArray();
    int[] input = new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50};
    minimumLengthUnsortedArray.findIndex(input);
  }

  private int findIndex(int[] input) {
    int minIndex = 0;
    int maxIndex = 0;
    int maxValue;
    int minValue;

    if (input == null || input.length == 0) {
      return 0;
    }

    int count = 0;

    for (int index = 0; index < input.length - 1; index++)
      if (input[index] <= input[index + 1]) {
        count++;
      }
    if (count == input.length - 1)
      return 0;


    for (int index = 0; index < input.length - 1; index++) {
      if (input[index] > input[index + 1]) {

        minIndex = index;
        maxIndex = 0;
        maxValue = input[index];
        minValue = input[index + 1];
        for (int secondIndex = index + 1; secondIndex < input.length; secondIndex++) {
          if (input[secondIndex] < maxValue) {
            if (secondIndex > maxIndex) {
              maxIndex = secondIndex;
            }
          } else if (input[secondIndex] > maxValue) {
            maxValue = input[secondIndex];
          }
          if (input[secondIndex] < minValue) {
            minValue = input[secondIndex];
          }
        }
        for (int reverseIndex = index - 1; reverseIndex >= 0; reverseIndex--) {
          if (input[reverseIndex] > minValue) {
            minIndex = reverseIndex;
          }
        }
        break;
      }
    }
    System.out.println(maxIndex + "-------" + minIndex);
    return maxIndex - minIndex + 1;
  }
}
