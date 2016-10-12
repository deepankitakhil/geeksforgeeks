package search;

/**
 * Created by Deepankit on 10/11/2016.
 */
public class FindKClosestElementsFromGivenValue {
    public static void main(String[] args) throws Exception {
        FindKClosestElementsFromGivenValue findKClosestElementsFromGivenValue = new FindKClosestElementsFromGivenValue();
        int[] input = new int[]{23, 38, 76, 99, 147, 147, 148, 159, 163, 189, 197, 230, 231, 279, 293, 316, 337, 353, 362, 393, 398, 399, 419, 449, 450, 459, 463, 487, 499, 521, 541, 561, 568, 570, 576, 601, 603, 634, 639, 648, 656, 659, 664, 676, 715, 755, 763, 793, 800, 808, 817, 829, 831, 852, 883, 898, 926, 926, 941, 947};
        int searchElement = 926;
        int noOfElements = 4;
        findKClosestElementsFromGivenValue.validateInput(input);
        int[] closestElements = findKClosestElementsFromGivenValue.findClosestElements(input, searchElement, noOfElements);
        display(closestElements);
    }

    private static void display(int[] closestElements) {
        for (int index = 0; index < closestElements.length; index++) {
            System.out.println(closestElements[index]);
        }
    }

    private void validateInput(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }

    private int[] findClosestElements(int[] input, int searchElement, int noOfElements) {
        int searchElementIndex = findSearchElementIndexUsingBinarySearch(input, 0, input.length, searchElement);
        if (searchElementIndex < 0)
            searchElementIndex = findClosestElementIndexFromSearchElement(input, Math.abs(searchElementIndex));
        return extractKClosestElementFromGivenValue(input, noOfElements, searchElementIndex);
    }

    private int[] extractKClosestElementFromGivenValue(int[] input, int noOfElements, int searchElementIndex) {
        int[] closestElements = new int[noOfElements];
        int count = 0;
        int leftIndex = searchElementIndex - 1;
        int rightIndex = searchElementIndex + 1;
        while (rightIndex < input.length && leftIndex > 0 && rightIndex - leftIndex != noOfElements + 2) {
            if ((input[searchElementIndex] - input[leftIndex]) < (input[rightIndex] - input[searchElementIndex])) {
                closestElements[count++] = input[leftIndex--];
            } else {
                closestElements[count++] = input[rightIndex++];
            }
        }
        while (count != noOfElements && rightIndex == input.length) {
            closestElements[count++] = input[leftIndex--];
        }
        while (count != noOfElements && leftIndex == 0) {
            closestElements[count++] = input[rightIndex++];
        }
        return closestElements;
    }

    private int findClosestElementIndexFromSearchElement(int[] input, int searchElementIndex) {
        return input[searchElementIndex] < input[searchElementIndex + 1] ? searchElementIndex : searchElementIndex + 1;
    }

    private int findSearchElementIndexUsingBinarySearch(int[] input, int startIndex, int endIndex, int searchElement) {
        int midIndex;
        if (input[startIndex] == searchElement)
            return startIndex;
        if (startIndex < endIndex) {
            midIndex = startIndex + (endIndex - startIndex) / 2;
            if (input[midIndex] == searchElement)
                return midIndex;
            else if (input[midIndex] > searchElement)
                return findSearchElementIndexUsingBinarySearch(input, startIndex, midIndex, searchElement);
            else
                return findSearchElementIndexUsingBinarySearch(input, midIndex + 1, endIndex, searchElement);
        }
        return -(startIndex);
    }
}
