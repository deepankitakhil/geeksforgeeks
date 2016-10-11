package dynamicprogramming;

/**
 * Created by Deepankit on 10/9/2016.
 */
public class MatrixChainMultiplication {
    public static void main(String[] args) throws Exception {
        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();
        int[] input = new int[]{30, 35, 15, 5, 10, 20, 25};
        matrixChainMultiplication.validate(input);
        long[][] calculateOrder = matrixChainMultiplication.calculateOrder(input);
        matrixChainMultiplication.print(calculateOrder);
    }

    private void print(long[][] output) {
        for (int rowIndex = 0; rowIndex < output.length; rowIndex++)
            for (int columnIndex = 0; columnIndex < output.length - rowIndex; columnIndex++)
                if (rowIndex < columnIndex)
                    System.out.println(output[rowIndex][columnIndex]);
    }

    private long[][] calculateOrder(int[] input) {
        int outputLength = input.length - 1;
        long[][] output = new long[outputLength][outputLength];
        initializeOutput(output);
        long optimalMultiplicationCount;
        for (int length = 2; length <= outputLength; length++) {
            for (int startIndex = 0; startIndex < outputLength - length + 1; startIndex++) {
                int endIndex = startIndex + length - 1;
                for (int k = startIndex; k < endIndex; k++) {
                    optimalMultiplicationCount = output[startIndex][k] + output[k + 1][endIndex] +
                            input[startIndex] * input[k + 1] * input[endIndex + 1];
                    if (optimalMultiplicationCount < output[startIndex][endIndex])
                        output[startIndex][endIndex] = optimalMultiplicationCount;
                }
            }
        }

        return output;
    }

    private void initializeOutput(long[][] output) {
        for (int rowIndex = 0; rowIndex < output.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < output.length; columnIndex++)
                if (rowIndex != columnIndex)
                    output[rowIndex][columnIndex] = Integer.MAX_VALUE;
        }
    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }
}
