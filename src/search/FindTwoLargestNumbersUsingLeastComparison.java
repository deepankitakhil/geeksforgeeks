package search;

/**
 * Created by Deepankit on 9/22/2016.
 */
public class FindTwoLargestNumbersUsingLeastComparison {
    public static void main(String[] args) {
        FindTwoLargestNumbersUsingLeastComparison findTwoLargestNumbersUsingLeastComparison = new FindTwoLargestNumbersUsingLeastComparison();
        int[] input = new int[]{121, 23, 5, 67, 122, 56, 657, 0, 89, 780};
        findTwoLargestNumbersUsingLeastComparison.find(input);
        findTwoLargestNumbersUsingLeastComparison.display(input);
    }

    private void display(int[] input) {
        System.out.println(input[0]);
        System.out.println(input[1] > input[2] ? input[1] : input[2]);
    }

    private void find(int[] input) {
        for (int index = input.length / 2 - 1; index >= 0; index--) {
            int maxHeapLimit = input.length - 1;
            maxHeapify(input, index, maxHeapLimit);
        }
    }

    private void maxHeapify(int[] input, int index, int maxHeapIndex) {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;
        int largestNumberIndex = index;
        int temp;
        if (leftChildIndex <= maxHeapIndex && input[leftChildIndex] > input[index])
            largestNumberIndex = leftChildIndex;
        if (rightChildIndex <= maxHeapIndex && input[largestNumberIndex] < input[rightChildIndex])
            largestNumberIndex = rightChildIndex;
        if (index != largestNumberIndex) {
            temp = input[index];
            input[index] = input[largestNumberIndex];
            input[largestNumberIndex] = temp;
            maxHeapify(input, index, largestNumberIndex);
        }
    }
}
