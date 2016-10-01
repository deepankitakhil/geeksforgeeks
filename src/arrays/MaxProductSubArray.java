package arrays;

/**
 * Created by Deepankit on 9/24/2016.
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
        int[] input = new int[]{-1, 2, 3, 4, 0};
        System.out.println(maxProductSubArray.findMaxProduct(input));
    }

    private int findMaxProduct(int[] input) {
        int count = 0;
        boolean isSingleNegativeElementPresent = false;
        for (int index = 0; index < input.length; index++)
            if (input[index] < 0)
                count++;
        if (count == 1)
            isSingleNegativeElementPresent = true;

        int maxProductForwardDirection = input[0];
        int product = 1;
        for (int index = 0; index < input.length; index++) {
            product = product * input[index];
            if (product > maxProductForwardDirection)
                maxProductForwardDirection = product;
            if (product == 0 && !isSingleNegativeElementPresent)
                product = 1;
            if (product < 0 && isSingleNegativeElementPresent)
                product = 1;
        }
        product = 1;
        int maxProductBackwardDirection = input[input.length - 1];
        for (int index = input.length - 1; index >= 0; index--) {
            product = product * input[index];
            if (product > maxProductBackwardDirection)
                maxProductBackwardDirection = product;
            if (product == 0 && !isSingleNegativeElementPresent)
                product = 1;
            if (product < 0 && isSingleNegativeElementPresent)
                product = 1;
        }
        return maxProductForwardDirection > maxProductBackwardDirection ? maxProductForwardDirection : maxProductBackwardDirection;
    }

}
