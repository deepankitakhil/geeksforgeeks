package sort;

/**
 * Created by Deepankit on 9/16/2016.
 */
public class IterativeQuickSort {
    public static void main(String[] args) {
        IterativeQuickSort iterativeQuickSort = new IterativeQuickSort();
        int[] input = {10, 7, 8, 9, 1, 5};
        iterativeQuickSort.sort(input);
        iterativeQuickSort.display(input);
    }

    private void sort(int[] input) {
        iterativeQuickSort(input, 0, input.length - 1);
    }

    private void iterativeQuickSort(int[] input, int startIndex, int endIndex) {
        int[] stack = new int[endIndex - startIndex + 1];
        int top = -1;
        int partition = 0;
        stack[++top] = startIndex;
        stack[++top] = endIndex;
        while (top >= 0) {
            endIndex = stack[top--];
            startIndex = stack[top--];
            partition = findPivot(input, startIndex, endIndex);
            if (partition - 1 > startIndex) {
                stack[++top] = startIndex;
                stack[++top] = partition - 1;
            }
            if (partition + 1 < endIndex) {
                stack[++top] = partition + 1;
                stack[++top] = endIndex;
            }
        }
    }

    private int findPivot(int[] input, int startIndex, int endIndex) {

        int arrayIndex = startIndex;
        int leftIndex = startIndex - 1;
        int temp;
        while (arrayIndex < endIndex) {
            if (input[arrayIndex] > input[endIndex])
                arrayIndex++;
            else {
                leftIndex++;
                temp = input[arrayIndex];
                input[arrayIndex] = input[leftIndex];
                input[leftIndex] = temp;
                arrayIndex++;
            }
        }
        temp = input[leftIndex + 1];
        input[leftIndex + 1] = input[endIndex];
        input[endIndex] = temp;
        return leftIndex + 1;
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }
}
