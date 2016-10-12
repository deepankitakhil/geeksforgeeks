package dynamicprogramming;

/**
 * Created by Deepankit on 10/10/2016.
 */
public class CountIncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        CountIncreasingSubsequence countIncreasingSubsequence = new CountIncreasingSubsequence();
        int[] input = new int[]{3, 4, 5};
        countIncreasingSubsequence.validate(input);
        System.out.println(countIncreasingSubsequence.countSubsequence(input));
    }

    private int countSubsequence(int[] input) {
        int sum = 0;
        int[] count = new int[input.length];
        for (int index = 0; index < input.length; index++)
            count[index] = 1;
        for (int index = 1; index < input.length; index++) {
            for (int secondIndex = 0; secondIndex < index; secondIndex++) {
                if (input[index] > input[secondIndex])
                    count[index] += count[secondIndex];
            }
        }
        for (int index = 0; index < input.length; index++)
            sum += count[index];
        return sum;
    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }

}
