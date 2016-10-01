package arrays;

/**
 * Created by Deepankit on 9/23/2016.
 */
public class FindTwoMissingNumbersInAscendingOrderIntegerArrayUsingXOR {
    public static void main(String[] args) {
        FindTwoMissingNumbersInAscendingOrderIntegerArrayUsingXOR findTwoMissingNumbersInAscendingOrderIntegerArrayUsingXOR = new FindTwoMissingNumbersInAscendingOrderIntegerArrayUsingXOR();
        int[] input = new int[]{1, 2, 4};
        findTwoMissingNumbersInAscendingOrderIntegerArrayUsingXOR.findElements(input);
    }

    private void findElements(int[] input) {
        int firstMissingNumber = Integer.MIN_VALUE;
        int secondMissingNumber;
        int sumOfMissingNumbers = 0;

        for (int index = 1; index <= input.length + 2; index++)
            sumOfMissingNumbers = sumOfMissingNumbers ^ index;

        for (int index = 0; index < input.length; index++)
            sumOfMissingNumbers = sumOfMissingNumbers ^ input[index];

        for (int index = 0; index < input.length - 1; index++) {
            if (input[index] + 1 != input[index + 1]) {
                firstMissingNumber = input[index] + 1;
                break;
            }
        }
        if (firstMissingNumber == Integer.MIN_VALUE)
            firstMissingNumber = input.length + 1;

        secondMissingNumber = sumOfMissingNumbers ^ firstMissingNumber;

        System.out.println(firstMissingNumber + "--" + secondMissingNumber);
    }
}
