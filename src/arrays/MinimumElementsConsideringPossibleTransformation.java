package arrays;

/**
 * Created by Deepankit on 9/23/2016.
 */
public class MinimumElementsConsideringPossibleTransformation {

    public static void main(String[] args) {
        MinimumElementsConsideringPossibleTransformation minimumElementsConsideringPossibleTransformation = new MinimumElementsConsideringPossibleTransformation();
        char[] input = new char[]{'R', 'G', 'B', 'R'};
        System.out.println(minimumElementsConsideringPossibleTransformation.transform(input));
    }

    private int transform(char[] input) {
        int redColorCount = 0;
        int blueColorCount = 0;
        int greenColorCount = 0;
        for (int index = 0; index < input.length; index++) {
            if (input[index] == 'R' || input[index] == 'r')
                redColorCount++;
            if (input[index] == 'G' || input[index] == 'g')
                greenColorCount++;
            if (input[index] == 'B' || input[index] == 'b')
                blueColorCount++;
        }

        if (redColorCount == input.length || blueColorCount == input.length || greenColorCount == input.length)
            return input.length;
        if (redColorCount % 2 == 0 && blueColorCount % 2 == 0 && greenColorCount % 2 == 0)
            return 2;
        if (redColorCount % 2 != 0 && blueColorCount % 2 != 0 && greenColorCount % 2 != 0)
            return 2;
        return 1;
    }
}
