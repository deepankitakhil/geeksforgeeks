package search;

/**
 * Created by Deepankit on 8/25/2016.
 */
public class MinDiffOfTwoNumberSetInThreeSortedArray {

    public static void main(String[] args) {
        MinDiffOfTwoNumberSetInThreeSortedArray minDiffOfTwoNumberSetInThreeSortedArray = new MinDiffOfTwoNumberSetInThreeSortedArray();
        minDiffOfTwoNumberSetInThreeSortedArray.calculateMinOfTwoNumberSetInThreeSortedArrays(new int[]{1, 4, 10}, new int[]{2, 15, 20}, new int[]{10, 12});
    }

    public String calculateMinOfTwoNumberSetInThreeSortedArrays(int[] input1, int[] input2, int[] input3) {
        int i = 0;
        int j = 0;
        int k = 0;
        int temp;
        int result = Integer.MAX_VALUE;
        while (i < input1.length && j < input2.length && k < input3.length) {
            int number1 = Math.abs(input1[i] - input2[j]);
            int number2 = Math.abs(input2[j] - input3[k]);
            int number3 = Math.abs(input3[k] - input1[i]);
            int maxOfThreeNumber = calculateMaxOfThreeNumber(number1, number2, number3);
            if (maxOfThreeNumber < result)
                result = maxOfThreeNumber;
            temp = calculateMinOfThreeNumber(input1[i], input2[j], input3[k]);
            if (temp == input1[i])
                i++;
            else if (temp == input2[j])
                j++;
            else
                k++;

        }
        if (i == input1.length)
            i--;
        if (j == input2.length)
            j--;
        if (k == input3.length)
            k--;
        System.out.println(i + "--" + j + "--" + k);
        return i + "--" + j + "--" + k;
    }

    private int calculateMaxOfThreeNumber(int number1, int number2, int number3) {
        if (number1 > number2) {
            if (number1 > number3)
                return number1;
            else
                return number3;
        } else if (number2 > number3)
            return number2;
        else
            return number3;
    }

    private int calculateMinOfThreeNumber(int number1, int number2, int number3) {
        if (number1 < number2) {
            if (number1 < number3)
                return number1;
            else
                return number3;
        } else if (number2 < number3)
            return number2;
        else
            return number3;
    }
}
