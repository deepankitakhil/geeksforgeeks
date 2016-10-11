package dynamicprogramming;

/**
 * Created by Deepankit on 10/9/2016.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) throws Exception {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        char[] inputOne = "ABCDEFGH".toCharArray();
        char[] inputTwo = "IJKLMNOP".toCharArray();
        longestCommonSubsequence.validateInput(inputOne, inputTwo);
        System.out.println(longestCommonSubsequence.findLongestSubsequence(inputOne, inputTwo));
    }

    private String findLongestSubsequence(char[] inputOne, char[] inputTwo) {
        int firstArrayInputLength = inputOne.length;
        int secondArrayInputLength = inputTwo.length;
        int[][] sameAppearance = new int[firstArrayInputLength + 1][secondArrayInputLength + 1];
        char[][] arrowMarks = new char[firstArrayInputLength][secondArrayInputLength];
        for (int firstIndex = 1; firstIndex < firstArrayInputLength + 1; firstIndex++) {
            for (int secondIndex = 1; secondIndex < secondArrayInputLength + 1; secondIndex++) {
                if (inputOne[firstIndex - 1] == inputTwo[secondIndex - 1]) {
                    sameAppearance[firstIndex][secondIndex] = sameAppearance[firstIndex - 1][secondIndex - 1] + 1;
                    arrowMarks[firstIndex - 1][secondIndex - 1] = 'D';
                } else if (inputOne[firstIndex - 1] != inputTwo[secondIndex - 1]) {
                    if (sameAppearance[firstIndex - 1][secondIndex] >= sameAppearance[firstIndex][secondIndex - 1]) {
                        sameAppearance[firstIndex][secondIndex] = sameAppearance[firstIndex - 1][secondIndex];
                        arrowMarks[firstIndex - 1][secondIndex - 1] = 'U';
                    } else {
                        sameAppearance[firstIndex][secondIndex] = sameAppearance[firstIndex][secondIndex - 1];
                        arrowMarks[firstIndex - 1][secondIndex - 1] = 'L';
                    }
                }
            }
        }
        return extractOutputString(inputOne, arrowMarks);
    }

    private String extractOutputString(char[] inputOne, char[][] arrowMarks) {
        StringBuilder output = new StringBuilder();
        int firstIndex = arrowMarks.length - 1;
        int secondIndex = arrowMarks[0].length - 1;
        while (firstIndex >= 0 && secondIndex >= 0)
            if (arrowMarks[firstIndex][secondIndex] == 'U') {
                firstIndex--;
            } else if (arrowMarks[firstIndex][secondIndex] == 'D') {
                output.append(inputOne[firstIndex]);
                secondIndex--;
                firstIndex--;
            } else {
                secondIndex--;
            }
        return output.reverse().toString();
    }

    private void validateInput(char[] inputOne, char[] inputTwo) throws Exception {
        if (inputOne == null || inputTwo == null || inputOne.length == 0 || inputTwo.length == 0)
            throw new Exception("invalid input");
    }
}
