package sort;

/**
 * Created by Deepankit on 10/13/2016.
 */
public class SortAnArrayInWaveFormWithoutSorting {
    public static void main(String[] args) throws Exception {
        SortAnArrayInWaveFormWithoutSorting sortAnArrayInWaveFormWithoutSorting = new SortAnArrayInWaveFormWithoutSorting();
        int[] input = new int[]{10, 5, 6, 3, 2, 20, 100, 80};
        sortAnArrayInWaveFormWithoutSorting.validate(input);
        sortAnArrayInWaveFormWithoutSorting.sortInWaveForm(input);
        sortAnArrayInWaveFormWithoutSorting.print(input);
    }

    private void sortInWaveForm(int[] input) {
        for (int index = 0; index < input.length; index = index + 2) {
            if (index > 0 && input[index] < input[index - 1])
                swap(input, index, index - 1);
            if (index < input.length && input[index] < input[index + 1])
                swap(input, index, index + 1);
        }
    }

    private void swap(int[] input, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            input[firstIndex] = input[firstIndex] ^ input[secondIndex];
            input[secondIndex] = input[firstIndex] ^ input[secondIndex];
            input[firstIndex] = input[firstIndex] ^ input[secondIndex];
        }
    }

    private void print(int[] input) {
        int endIndex = input.length - 1;
        for (int index = 0; index <= endIndex; index++)
            System.out.println(input[index]);
    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }

}

