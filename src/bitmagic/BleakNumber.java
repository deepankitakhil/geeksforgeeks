package bitmagic;

/**
 * Created by Deepankit on 9/24/2016.
 */
public class BleakNumber {
    public static void main(String[] args) {
        BleakNumber bleakNumber = new BleakNumber();
        int input = 10;
        System.out.println(bleakNumber.isBleak(input));
    }

    private boolean isBleak(int input) {
        int maxSetBits = findMaxSetBits(input);
        for (int index = input - maxSetBits; index < input - 1; index++) {
            return input == countSetBits(index) + index;
        }
        return false;
    }

    private int findMaxSetBits(int input) {
        int count = 0;
        while (input > 0) {
            count++;
            input = input >> 1;
        }
        return count;
    }

    private int countSetBits(int input) {
        int count = 0;
        while (input > 0) {
            input = input & (input - 1);
            count++;
        }
        return count;
    }
}
