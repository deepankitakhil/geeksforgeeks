package arrays;

/**
 * Created by Deepankit on 9/23/2016.
 */
public class MaximizeValueOfIndexAndArrayElements {

    public static void main(String[] args) {
        MaximizeValueOfIndexAndArrayElements maximizeValueOfIndexAndArrayElements = new MaximizeValueOfIndexAndArrayElements();
        int[] input = new int[]{-1, -2, -3, 4, 10};
        System.out.println(maximizeValueOfIndexAndArrayElements.maximize(input));
    }

    private int maximize(int[] input) {
        int max = Integer.MIN_VALUE;
        int arrayLength = input.length;
        int min = Integer.MAX_VALUE;
        for (int index = 0; index < arrayLength; index++) {
            if (max < input[index] - index)
                max = input[index] - index;
            if (min > input[index] - index)
                min = input[index] - index;
        }
        return max - min;
    }
}
