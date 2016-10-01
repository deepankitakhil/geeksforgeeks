package sort;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deepankit on 9/18/2016.
 */
public class SurpassingCountOfElements {
    public static void main(String[] args) {
        SurpassingCountOfElements surpassingCountOfElements = new SurpassingCountOfElements();
        Map<Integer, Integer> inversionCount = new HashMap<>();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] duplicateInputArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        surpassingCountOfElements.surpassCount(input, inversionCount);
        surpassingCountOfElements.display(duplicateInputArray, inversionCount);
    }

    private void display(int[] duplicateInputArray, Map<Integer, Integer> inversionCount) {
        for (int index = 0; index < duplicateInputArray.length; index++) {
            if (inversionCount.get(duplicateInputArray[index]) != null)
                System.out.println(inversionCount.get(duplicateInputArray[index]));
            else
                System.out.println(0);
        }
    }

    private void surpassCount(int[] input, Map<Integer, Integer> inversionCount) {
        int midIndex;
        int endIndex;
        for (int i = 1; i < input.length; i = i * 2)
            for (int startIndex = 0; startIndex < input.length - 1; startIndex = startIndex + 2 * i) {
                midIndex = i + startIndex - 1;
                endIndex = midIndex + i > input.length - 1 ? input.length - 1 : midIndex + i;
                modifiedMergeSort(input, startIndex, midIndex, endIndex, inversionCount);
            }
    }

    private void modifiedMergeSort(int[] input, int startIndex, int midIndex, int endIndex, Map<Integer, Integer> inversionCount) {

        int leftArrayLength = midIndex - startIndex + 1;
        int rightArrayLength = endIndex - midIndex;

        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        for (int index = 0; index < leftArrayLength; index++)
            leftArray[index] = input[startIndex + index];

        for (int index = 0; index < rightArrayLength; index++)
            rightArray[index] = input[midIndex + 1 + index];

        int leftIndex = 0;
        int rightIndex = 0;
        int inversion = 0;
        int inputIndex = startIndex;
        while (leftIndex < leftArrayLength && rightIndex < rightArrayLength) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                inversion++;
                input[inputIndex++] = rightArray[rightIndex++];
            } else {
                if (inversion == 0)
                    input[inputIndex++] = leftArray[leftIndex++];
                else {
                    if (inversionCount.containsKey(leftArray[leftIndex])) {
                        Integer count = inversionCount.get(leftArray[leftIndex]);
                        inversionCount.put(leftArray[leftIndex], count + inversion);
                    } else
                        inversionCount.put(leftArray[leftIndex], 1);
                    input[inputIndex++] = leftArray[leftIndex++];

                }
            }
        }

        while (leftIndex < leftArrayLength) {
            if (inversion != 0)
                if (inversionCount.containsKey(leftArray[leftIndex])) {
                    Integer count = inversionCount.get(leftArray[leftIndex]);
                    inversionCount.put(leftArray[leftIndex], count + inversion);
                } else
                    inversionCount.put(leftArray[leftIndex], inversion);
            input[inputIndex++] = leftArray[leftIndex++];
        }

        while (rightIndex < rightArrayLength)
            input[inputIndex++] = rightArray[rightIndex++];

    }
}
