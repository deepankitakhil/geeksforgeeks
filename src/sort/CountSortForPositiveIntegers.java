package sort;

/**
 * Created by Deepankit on 9/16/2016.
 */
public class CountSortForPositiveIntegers {

    public static void main(String[] args) {
        CountSortForPositiveIntegers countSortForPositiveIntegers = new CountSortForPositiveIntegers();
        int[] input = {1, 4, 1, 2, 7, 5, 2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int maxRange = 9;
        countSortForPositiveIntegers.sort(input, 0, maxRange);
        countSortForPositiveIntegers.display(input);

    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void sort(int[] input, int minRange, int maxRange) {
        int[] occurrenceCounter = new int[maxRange + 1];
        int limitingInteger = maxRange + 1;

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
    }
}
