package arrays;

/**
 * Created by Deepankit on 10/13/2016.
 */
public class FindClosestPairInTwoSortedArray {
    public static void main(String[] args) throws Exception {
        FindClosestPairInTwoSortedArray findClosestPairInTwoSortedArray = new FindClosestPairInTwoSortedArray();
        int[] inputOne = new int[]{1, 4, 5, 7};
        int[] inputTwo = new int[]{10, 20, 30, 40};
        int givenSum = 48;
        findClosestPairInTwoSortedArray.validate(inputOne, inputTwo);
        findClosestPairInTwoSortedArray.findClosestPair(inputOne, inputTwo, givenSum);
    }

    private void findClosestPair(int[] inputOne, int[] inputTwo, int givenSum) {
        int leftArrayIndex = 0;
        int rightArrayIndex = inputTwo.length - 1;
        int desiredLeftArrayIndex = Integer.MIN_VALUE;
        int desiredRightArrayIndex = Integer.MIN_VALUE;
        int resultantSum = Integer.MAX_VALUE;
        int calculatedResultant = 0;
        while (leftArrayIndex < inputOne.length && rightArrayIndex >= 0) {
            calculatedResultant = Math.abs(inputOne[leftArrayIndex] + inputTwo[rightArrayIndex] - givenSum);
            if (resultantSum > calculatedResultant) {
                resultantSum = calculatedResultant;
                desiredLeftArrayIndex = leftArrayIndex;
                desiredRightArrayIndex = rightArrayIndex;
            }

            if (inputOne[leftArrayIndex] + inputTwo[rightArrayIndex] < givenSum)
                leftArrayIndex++;
            else
                rightArrayIndex--;
        }
        System.out.println(inputOne[desiredLeftArrayIndex] + " and " + inputTwo[desiredRightArrayIndex]);
    }

    private void validate(int[] inputOne, int[] inputTwo) throws Exception {
        if (inputOne == null || inputOne.length == 0 || inputTwo == null || inputTwo.length == 0)
            throw new Exception("invalid input");
    }
}
