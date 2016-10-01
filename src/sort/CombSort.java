package sort;

/**
 * Created by Deepankit on 9/19/2016.
 */
public class CombSort {
    public static void main(String[] args) {
        CombSort combSort = new CombSort();
        int[] input = new int[]{4, 5, 6, 56, 3, -44, 23, 7, 8, 9};
        combSort.sort(input);
        combSort.display(input);
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void sort(int[] input) {
        int temp;
        for (int index = (int) (input.length / 1.3); index > 0; index = (int) (index / 1.3)) {
            for (int i = 0; i < input.length - index; i++) {
                if (input[i + index] < input[i]) {
                    temp = input[i + index];
                    input[i + index] = input[i];
                    input[i] = temp;
                }
            }
        }
    }
}
