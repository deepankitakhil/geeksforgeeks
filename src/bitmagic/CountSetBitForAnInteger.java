package bitmagic;

/**
 * Created by Deepankit on 9/24/2016.
 */
public class CountSetBitForAnInteger {
    public static void main(String[] args) {
        CountSetBitForAnInteger countSetBitForAnInteger = new CountSetBitForAnInteger();
        int input = 0;
        System.out.println(countSetBitForAnInteger.countBits(input));
    }

    private int countBits(int input) {
        int count = 0;
        while (input > 0) {
            input = input & (input - 1);
            count++;
        }
        return count;
    }

}
