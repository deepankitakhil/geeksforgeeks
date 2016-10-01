package bitmagic;

/**
 * Created by Deepankit on 9/24/2016.
 */
public class CopySetBitInARange {
    public static void main(String[] args) {
        CopySetBitInARange copySetBitInARange = new CopySetBitInARange();
        int inputOne = 10;
        int inputTwo = 13;
        int rangeStartIndex = 2;
        int rangeEndIndex = 3;
        System.out.println(copySetBitInARange.copySetBits(inputOne, inputTwo, rangeStartIndex, rangeEndIndex));
    }

    private int copySetBits(int inputOne, int inputTwo, int rangeStartIndex, int rangeEndIndex) {
        int copyBitSetValue = 0;
        for (int index = rangeStartIndex - 1; index < rangeEndIndex; index++) {
            copyBitSetValue = copyBitSetValue | 1 << index;
        }
        return copyBitSetValue & inputTwo | inputOne;
    }
}
