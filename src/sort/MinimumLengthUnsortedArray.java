package sort;

/**
 * Created by Deepankit on 9/22/2016.
 */
public class MinimumLengthUnsortedArray {
    public static void main(String[] args) {
        MinimumLengthUnsortedArray minimumLengthUnsortedArray = new MinimumLengthUnsortedArray();
        int[] input = new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50};
        minimumLengthUnsortedArray.findIndex(input);
    }

    private void findIndex(int[] input) {
        int startIndex = -1;
        int endIndex = input.length;
        int max;
        int min;
        for (int index = 1; index < input.length - 1; index++) {
            if (input[index - 1] > input[index])
                startIndex = index - 1;
            if (input[input.length - index] < input[input.length - 1 - index])
                endIndex = input.length - index;
            if (startIndex > 0 && endIndex < input.length)
                break;
        }
        max = input[endIndex];
        min = input[startIndex];
        for (int index = startIndex; index <= endIndex; index++) {
            if (max < input[index])
                max = input[index];
            if (min > input[index])
                min = input[index];
        }
        for (int index = 0; index <= startIndex - 1; index++)
            if (input[index] > min) {
                startIndex = index;
                break;
            }

        for (int index = endIndex + 1; index < input.length; index++) {
            if (input[index] < max) {
                endIndex = index;
                break;
            }
            endIndex++;
        }
        System.out.println(startIndex + "------" + endIndex);
    }
}
