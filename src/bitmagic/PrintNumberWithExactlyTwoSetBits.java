package bitmagic;

/**
 * Created by Deepankit on 9/24/2016.
 */
public class PrintNumberWithExactlyTwoSetBits {

    public static void main(String[] args) {
        PrintNumberWithExactlyTwoSetBits printNumberWithExactlyTwoSetBits = new PrintNumberWithExactlyTwoSetBits();
        int input = 5;
        printNumberWithExactlyTwoSetBits.printNumbersWithTwoSetBits(input);

    }

    private void printNumbersWithTwoSetBits(int input) {
        while (input > 0) {
            int digit = input;
            int count = 0;
            while (digit > 0) {
                digit = digit & (digit - 1);
                count++;
                if (count > 2)
                    break;
            }
            if (count == 2)
                System.out.println(input);
            input--;
        }
    }
}
