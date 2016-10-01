package bitmagic;

/**
 * Created by Deepankit on 9/24/2016.
 */
public class PrintEvenOccurringElementsInArray {
    public static void main(String[] args) {
        PrintEvenOccurringElementsInArray printEvenOccurringElementsInArray = new PrintEvenOccurringElementsInArray();
        int[] input = new int[]{1, 4, 7, 5, 9, 7, 3, 4, 6, 8, 3, 0, 3};
        printEvenOccurringElementsInArray.printEvenOccurrence(input);
    }

    private void printEvenOccurrence(int[] input) {
        long xor = 0L;
        long position;
        for (int index = 0; index < input.length; index++) {
            position = 1 << input[index];
            xor = xor ^ position;
        }
        for (int index = 0; index < input.length; index++) {
            position = 1 << input[index];
            long condition = position & xor;
            if (condition == 0) {
                System.out.println(input[index]);
                xor = xor ^ position;
            }
        }
    }
}
