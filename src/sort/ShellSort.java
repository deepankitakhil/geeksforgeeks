package sort;

/**
 * Created by Deepankit on 9/19/2016.
 */
public class ShellSort {
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] input = new int[]{73, 67, 56, 32, 52, 41, 83, 37, 32, 10};
        shellSort.sort(input);
        shellSort.display(input);
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void sort(int[] input) {
        int temp;
        int j;
        for (int gap = input.length / 2; gap > 0; gap /= 2) {
            for (int index = gap; index < input.length; index++) {
                temp = input[index];
                for (j = index; j - gap >= 0; j = j - gap) {
                    if (temp < input[j - gap]) {
                        input[j] = input[j - gap];
                        input[j - gap] = temp;
                    }
                }
            }
        }
    }
}