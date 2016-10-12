package dynamicprogramming;

/**
 * Created by Deepankit on 10/12/2016.
 */
public class MemoizedFactorial {
    public static void main(String[] args) {
        MemoizedFactorial memoizedFactorial = new MemoizedFactorial();
        int input = 5;
        int output = memoizedFactorial.findFactorial(input);
        System.out.println(output);
    }

    private int findFactorial(int input) {
        int[] memoizedTable = new int[input + 1];
        if (memoizedTable[input] != 0)
            return memoizedTable[input];
        if (input == 0)
            return 1;
        return input * findFactorial(input - 1);

    }
}
