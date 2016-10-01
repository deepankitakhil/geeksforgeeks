package bitmagic;

/**
 * Created by Deepankit on 9/23/2016.
 */
public class SwapThreeVariableUsingXOR {
    public static void main(String[] args) {
        SwapThreeVariableUsingXOR swapThreeVariableUsingXOR = new SwapThreeVariableUsingXOR();
        swapThreeVariableUsingXOR.swapUsingSixXOROperations(10, 20, 30);
        swapThreeVariableUsingXOR.swapUsingFourXOROperations(10, 20, 30);
    }

    private void swapUsingFourXOROperations(int first, int second, int third) {
        first = first ^ second ^ third;
        second = first ^ second ^ third;
        third = first ^ second ^ third;
        first = first ^ second ^ third;
        System.out.println(first + ", " + second + ", " + third);
    }

    private void swapUsingSixXOROperations(int first, int second, int third) {
        first = first ^ second;
        second = first ^ second;
        first = first ^ second;

        third = third ^ first;
        first = third ^ first;
        third = first ^ third;

        System.out.println(first + ", " + second + ", " + third);
    }
}
