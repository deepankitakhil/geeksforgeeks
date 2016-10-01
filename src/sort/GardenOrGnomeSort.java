package sort;

/**
 * Created by Deepankit on 9/17/2016.
 */
public class GardenOrGnomeSort {

    public static void main(String[] args) {
        GardenOrGnomeSort gardenOrGnomeSort = new GardenOrGnomeSort();
        int[] input = new int[]{30, 87, 72, 5, 48, 15, 80, 45, 59, 86};
        gardenOrGnomeSort.sort(input);
        gardenOrGnomeSort.display(input);
    }

    private void sort(int[] input) {
        int backwardIndex;
        for (int index = 0; index < input.length - 1; index++) {
            if (input[index] > input[index + 1]) {
                backwardIndex = index;
                swap(input, index, index + 1);
                while (backwardIndex >= 1 && input[backwardIndex] < input[backwardIndex - 1]) {
                    swap(input, backwardIndex, backwardIndex - 1);
                    backwardIndex--;
                }
            }
        }
    }

    private void swap(int[] input, int fromIndex, int toIndex) {
        int temp = input[fromIndex];
        input[fromIndex] = input[toIndex];
        input[toIndex] = temp;
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }
}
