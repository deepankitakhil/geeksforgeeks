package arrays;

/**
 * Created by Deepankit on 9/23/2016.
 */
public class SingleBitFlipToMakeAllBitsSame {
    public static void main(String[] args) {
        SingleBitFlipToMakeAllBitsSame singleBitFlipToMakeAllBitsSame = new SingleBitFlipToMakeAllBitsSame();
        int[] input = new int[]{1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(singleBitFlipToMakeAllBitsSame.flipIfPossible(input));
    }

    private boolean flipIfPossible(int[] input) {
        int zeroBitCount = 0;
        int oneBitCount = 0;
        int index = 0;

        while ((zeroBitCount <= 1 || oneBitCount <= 1) && index < input.length) {
            if (input[index] == 0)
                zeroBitCount++;
            else
                oneBitCount++;
            index++;
        }

        if (zeroBitCount == 1 && oneBitCount == index - zeroBitCount || oneBitCount == 1 && zeroBitCount == index - oneBitCount)
            return true;
        return false;
    }
}
