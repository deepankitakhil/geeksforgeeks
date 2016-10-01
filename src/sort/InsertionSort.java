package sort;

/**
 * Created by Deepankit on 9/1/2016.
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(new int[]{10, 6, 9, 8, 7, 3, 5, 4, 1, 2, 1});
    }

    private void sort(int[] input) {
        int temp;
        for (int i = 0; i < input.length - 1; i++)
            for (int j = i + 1; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        for (int i = 0; i < input.length; i++)
            System.out.println(input[i]);
    }
}
