package dynamicprogramming;

/**
 * Created by Deepankit on 10/10/2016.
 */
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = new LongestContinuousIncreasingSubsequence();
        int[] input = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
        longestContinuousIncreasingSubsequence.findLengthOfLongestIncreasingSubsequence(input);
    }

    private void findLengthOfLongestIncreasingSubsequence(int[] input) {
        int maxSoFar = 1;
        int maxTillNow = 1;
        for (int index = 0; index < input.length - 1; index++) {
            if (input[index] < input[index + 1]) {
                maxSoFar++;
                maxTillNow = maxTillNow > maxSoFar ? maxTillNow : maxSoFar;
            } else {
                maxSoFar = 1;
            }
        }
        System.out.println(maxTillNow);
    }

}
