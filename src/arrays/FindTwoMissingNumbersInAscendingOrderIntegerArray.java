package arrays;

/**
 * Created by Deepankit on 9/23/2016.
 */
public class FindTwoMissingNumbersInAscendingOrderIntegerArray {
    public static void main(String[] args) {
        FindTwoMissingNumbersInAscendingOrderIntegerArray findTwoMissingNumbersInAscendingOrderIntegerArray = new FindTwoMissingNumbersInAscendingOrderIntegerArray();
        int[] input = new int[]{1, 2, 4};
        findTwoMissingNumbersInAscendingOrderIntegerArray.findNumbers(input);
    }

    private void findNumbers(int[] input) {
        int sum = ((input.length + 2) * (input.length + 3)) / 2;
        int firstMissingNumber = Integer.MIN_VALUE;
        int secondMissingNumber;
        int currentSum = 0;

        for (int index = 0; index < input.length; index++)
            currentSum += input[index];

        for (int index = 0; index < input.length - 1; index++) {
            if (input[index] + 1 != input[index + 1]) {
                firstMissingNumber = input[index] + 1;
                break;
            }
        }
        if (firstMissingNumber == Integer.MIN_VALUE)
            firstMissingNumber = input.length + 1;
        sum = sum - currentSum;
        secondMissingNumber = sum - firstMissingNumber;

        System.out.println(firstMissingNumber + "--" + secondMissingNumber);
    }
}
