package search;

/**
 * Created by Deepankit on 8/24/2016.
 */
public class MinInThreeSortedArray {

    public static void main(String[] args) {
        MinInThreeSortedArray minInThreeSortedArray = new MinInThreeSortedArray();
        System.out.println(minInThreeSortedArray.findMinimum(new int[]{1, 4, 12}, new int[]{12, 10, 11}, new int[]{12, 22}));
    }

    private String findMinimum(int[] input1, int[] input2, int[] input3) {
        int i = 0, j = 0, k = 0;
        int max;
        int min;
        int difference = Integer.MAX_VALUE;
        while (i < input1.length && j < input2.length && k < input3.length) {
            max = calculateMax(input1[i], input2[j], input3[k]);
            min = calculateMin(input1[i], input2[j], input3[k]);
            if (difference > (max - min)) {
                difference = max - min;
            }
            if (min == input1[i])
                i++;
            else if (min == input2[j])
                j++;
            else if (min == input3[k])
                k++;

        }
        if (i == input1.length) i = i - 1;
        if (j == input2.length) j = j - 1;
        if (k == input3.length) k = k - 1;
        return i + "-" + j + "-" + k;
    }

    private int calculateMin(int input1, int input2, int input3) {
        if (input1 < input2) {
            if (input1 < input3)
                return input1;
            else
                return input3;
        } else if (input2 < input3)
            return input2;
        else
            return input3;
    }

    private int calculateMax(int input1, int input2, int input3) {
        if (input1 > input2) {
            if (input1 > input3)
                return input1;
            else
                return input3;
        } else if (input2 > input3)
            return input2;
        else return input3;
    }
}
