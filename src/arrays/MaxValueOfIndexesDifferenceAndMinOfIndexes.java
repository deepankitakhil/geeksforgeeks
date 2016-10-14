package arrays;

/**
 * Created by Deepankit on 10/13/2016.
 */
public class MaxValueOfIndexesDifferenceAndMinOfIndexes {
    public static void main(String[] args) {
        MaxValueOfIndexesDifferenceAndMinOfIndexes maxValueOfIndexesDifferenceAndMinOfIndexes = new MaxValueOfIndexesDifferenceAndMinOfIndexes();
        int[] input = new int[]{8, 1, 9, 4};
        System.out.println(maxValueOfIndexesDifferenceAndMinOfIndexes.findMaxProduct(input));
    }

    private int findMaxProduct(int[] input) {
        int leftIndex = 0;
        int rightIndex = input.length - 1;
        int maxProduct = Integer.MIN_VALUE;
        while (leftIndex < rightIndex) {
            if (input[leftIndex] < input[rightIndex]) {
                maxProduct = maxProduct < (input[leftIndex] * (rightIndex - leftIndex)) ? input[leftIndex] * (rightIndex - leftIndex) : maxProduct;
                leftIndex++;
            } else {
                maxProduct = maxProduct < (input[rightIndex] * (rightIndex - leftIndex)) ? input[rightIndex] * (rightIndex - leftIndex) : maxProduct;
                rightIndex--;
            }
        }
        return maxProduct;
    }
}
