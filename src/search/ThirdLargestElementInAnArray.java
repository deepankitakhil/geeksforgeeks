package search;

/**
 * Created by Deepankit on 8/31/2016.
 */
public class ThirdLargestElementInAnArray {

    public static void main(String[] args) {
        ThirdLargestElementInAnArray thirdLargestElementInAnArray = new ThirdLargestElementInAnArray();
        System.out.println(thirdLargestElementInAnArray.findThirdLargest(new int[]{19, -10, 20, 14, 2, 16, 10}));
    }

    private int findThirdLargest(int[] input) {
        int first = input[0];
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int index = 1; index < input.length; index++) {
            if (input[index] > first) {
                third = second;
                second = first;
                first = input[index];
            } else if (input[index] > second) {
                third = second;
                second = input[index];
            } else if (input[index] > third) {
                third = input[index];
            }
        }
        return third;
    }
}
