package bitmagic;

/**
 * Created by Deepankit on 10/11/2016.
 */
public class EvenOddNumber {
    public static void main(String[] args) {
        EvenOddNumber evenOddNumber = new EvenOddNumber();
        int input = 11;
        System.out.println(evenOddNumber.isEven(input));
    }

    private boolean isEven(int input) {
        return (input & 1) == 0;
    }
}
