package search;

/**
 * Created by Deepankit on 8/20/2016.
 */
public class RecursiveFibonacciSearch {

    public static void main(String[] args) {
        RecursiveFibonacciSearch recursiveFibonacciSearch = new RecursiveFibonacciSearch();
        System.out.println(recursiveFibonacciSearch.search(new int[]{1, 3, 4, 5, 6, 7, 14, 18}, 18));
    }

    public int search(int[] input, int searchElement) {
        int firstFibonacci = findClosestFibonacciNumberGreaterThanOrEqualToArrayLength(input.length);
        int secondFibonacci = firstFibonacci / 3;
        int thirdFibonacci = (firstFibonacci * 2) / 3;
        return recursiveSearch(input, thirdFibonacci, searchElement);
    }

    private int recursiveSearch(int[] input, int fibonacciIndex, int searchElement) {
        if (searchElement == input[fibonacciIndex])
            return fibonacciIndex;
        if (searchElement <= input[fibonacciIndex])
            return 0;
        return -999;
    }

    private int findClosestFibonacciNumberGreaterThanOrEqualToArrayLength(int length) {
        int firstNumber = 0;
        int secondNumber = 1;
        int thirdNumber = firstNumber + secondNumber;
        while (length > thirdNumber) {
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            thirdNumber = firstNumber + secondNumber;
        }
        return thirdNumber;
    }
}
