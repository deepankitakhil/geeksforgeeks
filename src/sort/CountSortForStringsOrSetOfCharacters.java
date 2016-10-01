package sort;

/**
 * Created by Deepankit on 9/16/2016.
 */
public class CountSortForStringsOrSetOfCharacters {

    public static void main(String[] args) {
        CountSortForStringsOrSetOfCharacters countSortForStringsOrSetOfCharacters = new CountSortForStringsOrSetOfCharacters();
        String input = "geeksforgeeks";
        int maxRange = 256;
        countSortForStringsOrSetOfCharacters.sort(input.toCharArray(), maxRange);

    }

    private void display(char[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void sort(char[] input, int maxRange) {
        int[] occurrenceCounter = new int[maxRange];
        int index = 0;

        for (int arrayIndex = 0; arrayIndex < input.length; arrayIndex++) {
            occurrenceCounter[input[arrayIndex]] += 1;
            input[arrayIndex] = 0;
        }
        for (int arrayIndex = 0; arrayIndex < occurrenceCounter.length; arrayIndex++) {
            if (occurrenceCounter[arrayIndex] != 0) {
                input[index] = (char) arrayIndex;
                index += occurrenceCounter[arrayIndex];
            }
        }

        for (int arrayIndex = 1; arrayIndex < input.length; arrayIndex++) {
            if (input[arrayIndex] == 0 && input[arrayIndex] != input[arrayIndex - 1])
                input[arrayIndex] = input[arrayIndex - 1];
        }
        display(input);
    }
}
