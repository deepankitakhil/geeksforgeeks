package strings;

/**
 * Created by Deepankit on 10/16/2016.
 */
public class FindMissingwordsInTwoSentences {
    public static void main(String[] args) {
        FindMissingwordsInTwoSentences findMissingwordsInTwoSentences = new FindMissingwordsInTwoSentences();
        String inputOne = "hackerrank is good programming platform";
        String inputTwo = "is good";
        String[] missingwordsInTwoSentences = findMissingwordsInTwoSentences.findMissingwordsInTwoSentences(inputOne, inputTwo);
        findMissingwordsInTwoSentences.display(missingwordsInTwoSentences);
    }

    private void display(String[] missingwordsInTwoSentences) {
        for (int index = 0; index < missingwordsInTwoSentences.length; index++)
            System.out.println(missingwordsInTwoSentences[index]);
    }

    private String[] findMissingwordsInTwoSentences(String inputOne, String inputTwo) {
        int count = 0;
        String[] splitFirstString = inputOne.split(" ");
        String[] splitSecondString = inputTwo.split(" ");
        String[] output = new String[splitFirstString.length - splitSecondString.length];
        int firstIndex;
        int secondIndex;
        for (firstIndex = 0, secondIndex = 0; firstIndex < splitFirstString.length && secondIndex < splitSecondString.length; firstIndex++) {
            if (splitFirstString[firstIndex].equals(splitSecondString[secondIndex]))
                secondIndex++;
            else output[count++] = splitFirstString[firstIndex];
        }
        while (firstIndex <= splitFirstString.length - 1)
            output[count++] = splitFirstString[firstIndex++];
        return output;
    }
}
