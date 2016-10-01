package sort;

/**
 * Created by Deepankit on 9/17/2016.
 */
public class OddEvenSort {

    public static void main(String[] args) {
        OddEvenSort oddEvenSort = new OddEvenSort();
        int[] input = new int[]{34, 2, 10, -9};
        oddEvenSort.sort(input);
        oddEvenSort.display(input);

    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void sort(int[] input) {
        int temp;
        for (int index = 0; index < input.length; index++) {
            for (int oddIndex = 1; oddIndex < input.length - 1; oddIndex += 2) {
                if (input[oddIndex] >= input[oddIndex + 1]) {
                    temp = input[oddIndex];
                    input[oddIndex] = input[oddIndex + 1];
                    input[oddIndex + 1] = temp;
                }
            }
            for (int evenIndex = 0; evenIndex < input.length - 1; evenIndex += 2) {
                if (input[evenIndex] >= input[evenIndex + 1]) {
                    temp = input[evenIndex];
                    input[evenIndex] = input[evenIndex + 1];
                    input[evenIndex + 1] = temp;
                }
            }
        }
    }
}
