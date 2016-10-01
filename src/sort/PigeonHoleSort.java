package sort;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Deepankit on 9/19/2016.
 */
public class PigeonHoleSort {

    public static void main(String[] args) {
        PigeonHoleSort pigeonHoleSort = new PigeonHoleSort();
        int[] input = new int[]{34, 2, 10, -9};
        pigeonHoleSort.sort(input);
        pigeonHoleSort.display(input);
    }

    private void display(int[] input) {
        for (int index = 0; index < input.length; index++)
            System.out.println(input[index]);
    }

    private void sort(int[] input) {
        int maxValue = findMax(input);
        int minValue = findMin(input);
        int range = maxValue - minValue + 1;
        List[] pigeonHole = new List[range];

        for (int index = 0; index < input.length; index++) {
            int pigeonHoleIndex = input[index] - minValue;
            if (pigeonHole[pigeonHoleIndex] == null) {
                pigeonHole[pigeonHoleIndex] = new LinkedList();
            }
            List pigeonHoleList = pigeonHole[pigeonHoleIndex];
            pigeonHoleList.add(input[index]);
            pigeonHole[pigeonHoleIndex] = pigeonHoleList;
        }
        int inputIndex = 0;
        for (int index = 0; index < pigeonHole.length; index++) {
            if (pigeonHole[index] != null) {
                ListIterator iterator = pigeonHole[index].listIterator();
                while (iterator.hasNext()) {
                    input[inputIndex] = (int) iterator.next();
                    inputIndex++;
                }
            }
        }
    }

    private int findMax(int[] input) {
        int maxValue = Integer.MIN_VALUE;
        for (int index = 0; index < input.length; index++)
            if (maxValue < input[index])
                maxValue = input[index];
        return maxValue;
    }

    private int findMin(int[] input) {
        int minValue = Integer.MAX_VALUE;
        for (int index = 0; index < input.length; index++)
            if (minValue > input[index])
                minValue = input[index];
        return minValue;
    }
}
