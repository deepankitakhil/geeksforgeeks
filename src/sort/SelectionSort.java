package sort;

/**
 * Created by Deepankit on 9/1/2016.
 */
public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(new int[]{90, 78, 7, 81});
    }

    private void sort(int[] input) {
        int minElementIndex, temp;
        for (int index = 0; index < input.length; index++) {
            minElementIndex = index;
            for (int secondIndex = index + 1; secondIndex < input.length; secondIndex++) {
                if (input[minElementIndex] >= input[secondIndex])
                    minElementIndex = secondIndex;

            }
            temp = input[index];
            input[index] = input[minElementIndex];
            input[minElementIndex] = temp;

        }
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }
}
