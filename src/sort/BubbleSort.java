package sort;

/**
 * Created by Deepankit on 9/1/2016.
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(new int[]{10, 9, 8, 7, 6, 5});
    }

    private void sort(int[] input) {
        int temp;
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        for (int i = 0; i < input.length; i++)
            System.out.println(input[i]);
    }
}
