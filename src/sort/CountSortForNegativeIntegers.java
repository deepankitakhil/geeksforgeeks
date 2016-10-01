package sort;

/**
 * Created by Deepankit on 9/16/2016.
 */
public class CountSortForNegativeIntegers {

    public static void main(String[] args) {
        CountSortForNegativeIntegers countSortForNegativeIntegers = new CountSortForNegativeIntegers();
        int[] input = {1, 4, 1, -2, -7, 5, 2, 0, 1, -2, 3, 4, -5, 6, 7, 8, -9};
        int maxRange = 9;
        countSortForNegativeIntegers.sort(input, -9, maxRange);
        countSortForNegativeIntegers.display(input);

    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void sort(int[] input, int minRange, int maxRange) {
        int[] occurrenceCounter = new int[Math.abs(minRange) + Math.abs(maxRange) + 1];
        int relativeCounter = Math.abs(minRange);
        int limitingInteger = maxRange + relativeCounter + 1;
        for (int arrayIndex = 0; arrayIndex < input.length; arrayIndex++) {
            input[arrayIndex] = input[arrayIndex] + relativeCounter;
        }

        int index = 0;
        for (int arrayIndex = 0; arrayIndex < input.length; arrayIndex++) {
            occurrenceCounter[input[arrayIndex]] += 1;
            input[arrayIndex] = limitingInteger;
        }
        for (int arrayIndex = 0; arrayIndex < occurrenceCounter.length; arrayIndex++) {
            if (occurrenceCounter[arrayIndex] != 0) {
                input[index] = arrayIndex;
                index += occurrenceCounter[arrayIndex];
            }
        }
        for (int arrayIndex = 1; arrayIndex < input.length; arrayIndex++) {
            if (input[arrayIndex] == limitingInteger && input[arrayIndex] != input[arrayIndex - 1])
                input[arrayIndex] = input[arrayIndex - 1];
        }

        for (int arrayIndex = 0; arrayIndex < input.length; arrayIndex++) {
            input[arrayIndex] = input[arrayIndex] - relativeCounter;
        }

    }
}
