package dynamicprogramming;

/**
 * Created by Deepankit on 10/9/2016.
 */
public class MaxRodLengthRecursiveSolution {
    public static void main(String[] args) throws Exception {
        MaxRodLengthRecursiveSolution maxRodLengthRecursiveSolution = new MaxRodLengthRecursiveSolution();
        int[] input = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] solution = new int[input.length + 1];
        maxRodLengthRecursiveSolution.validate(input);
        maxRodLengthRecursiveSolution.maxRodLength(input, solution, input.length);
        display(solution);
    }

    private static void display(int[] solution) {
        for (int index = 1; index < solution.length; index++)
            System.out.println(solution[index]);
    }

    private int maxRodLength(int[] input, int[] solution, int length) {
        int maximumValue;
        if (length == 0)
            return 0;
        if (solution[length] > 0)
            return solution[length];

        maximumValue = Integer.MIN_VALUE;
        for (int index = 0; index < length; index++) {
            int calculatedValue = input[index] + maxRodLength(input, solution, length - index - 1);
            if (maximumValue < calculatedValue)
                maximumValue = calculatedValue;
        }
        solution[length] = maximumValue;
        return maximumValue;
    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input.");
    }
}
