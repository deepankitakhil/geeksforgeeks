package sort;

/**
 * Created by Deepankit on 9/17/2016.
 */
public class BogoSort {
    public static void main(String[] args) {
        BogoSort bogoSort = new BogoSort();
        int[] input = new int[]{3, 2, 5, 1, 0, 4};
        bogoSort.sort(input);
    }

    private void sort(int[] input) {

        boolean alreadySorted = isAlreadySorted(input);
        if (!alreadySorted) {
            randomizeInput(input);
            sort(input);
        } else
            display(input);
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++) {
            System.out.println(input[index]);
        }
    }

    private void randomizeInput(int[] input) {
        int newIndex;
        int temp;
        for (int index = 0; index < input.length; index++) {
            newIndex = (int) (Math.random() * 10) % (input.length);
            temp = input[newIndex];
            input[newIndex] = input[index];
            input[index] = temp;
        }
    }

    private boolean isAlreadySorted(int[] input) {

        for (int index = 0; index < input.length - 1; index++)
            if (input[index] > input[index + 1])
                return false;
        return true;
    }
}
