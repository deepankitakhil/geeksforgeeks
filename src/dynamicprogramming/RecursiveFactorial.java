package dynamicprogramming;

/**
 * Created by Deepankit on 10/12/2016.
 */
public class RecursiveFactorial {
    public static void main(String[] args) {
        RecursiveFactorial recursiveFactorial = new RecursiveFactorial();
        int input = 5;
        int output = recursiveFactorial.findFactorial(input);
        System.out.println(output);
    }

    private int findFactorial(int input) {
        if (input == 0) return 1;
        return input * findFactorial(input - 1);
    }
}
