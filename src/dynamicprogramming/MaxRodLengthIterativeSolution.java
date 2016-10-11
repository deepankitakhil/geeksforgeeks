package dynamicprogramming;

/**
 * Created by Deepankit on 10/9/2016.
 */
public class MaxRodLengthIterativeSolution {

    public static void main(String[] args) throws Exception {
        MaxRodLengthIterativeSolution maxRodLengthIterativeSolution = new MaxRodLengthIterativeSolution();
        int[] input = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        maxRodLengthIterativeSolution.validateInput(input);
        maxRodLengthIterativeSolution.findMaxValueFromCut(input);
    }

    private void validateInput(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("Invalid input array");
    }

    private void findMaxValueFromCut(int[] input) {
        int[] auxiliaryInput = new int[input.length + 1];
        int[] optimumCut = new int[input.length];
        int[] maximumRevenue = new int[input.length];
        for (int index = 1; index < auxiliaryInput.length; index++)
            auxiliaryInput[index] = input[index - 1];
        for (int firstIndex = 1; firstIndex < auxiliaryInput.length; firstIndex++) {
            int optimumCutIndex = firstIndex;
            int maximumValue = auxiliaryInput[firstIndex];
            for (int secondIndex = 1; secondIndex <= firstIndex; secondIndex++) {
                int auxiliaryMaxValue = auxiliaryInput[secondIndex] + auxiliaryInput[firstIndex - secondIndex];
                if (maximumValue < auxiliaryMaxValue) {
                    maximumValue = auxiliaryMaxValue;
                    optimumCutIndex = secondIndex;
                }
            }
            optimumCut[firstIndex - 1] = optimumCutIndex;
            maximumRevenue[firstIndex - 1] = maximumValue;
        }
        for (int index = 0; index < input.length; index++) {
            System.out.print(optimumCut[index] + "====" + maximumRevenue[index] + "   ");
        }
    }
}
