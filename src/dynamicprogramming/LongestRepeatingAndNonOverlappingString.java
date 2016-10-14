package dynamicprogramming;

/**
 * Created by Deepankit on 10/12/2016.
 */
public class LongestRepeatingAndNonOverlappingString {
    public static void main(String[] args) throws Exception {
        LongestRepeatingAndNonOverlappingString longestRepeatingAndNonOverlappingString = new LongestRepeatingAndNonOverlappingString();
        String input = "aabaabaaba";
        longestRepeatingAndNonOverlappingString.validate(input);
        String longestSubstring = longestRepeatingAndNonOverlappingString.findLongestSubstring(input);
        System.out.println(longestSubstring);
    }

    private String findLongestSubstring(String input) {
        int[][] sequenceMatrix = new int[input.length() + 1][input.length() + 1];
        StringBuilder output = new StringBuilder();
        int resultLength = 0;
        int index = 0;
        for (int firstIndex = 1; firstIndex <= input.length(); firstIndex++)
            for (int secondIndex = firstIndex + 1; secondIndex <= input.length(); secondIndex++) {
                if (input.charAt(firstIndex - 1) == input.charAt(secondIndex - 1) && (secondIndex - firstIndex) > sequenceMatrix[firstIndex - 1][secondIndex - 1]) {
                    sequenceMatrix[firstIndex][secondIndex] = sequenceMatrix[firstIndex - 1][secondIndex - 1] + 1;
                    if (resultLength < sequenceMatrix[firstIndex][secondIndex]) {
                        resultLength = sequenceMatrix[firstIndex][secondIndex];
                        index = firstIndex > index ? firstIndex : index;
                    }
                }
            }

        if (resultLength > 0) {
            for (int i = index - resultLength + 1; i <= index; i++)
                output.append(input.charAt(i - 1));

        }
        return output.toString();
    }


    private void validate(String input) throws Exception {
        if (input == null || input.length() == 0)
            throw new Exception("invalid input");
    }
}
