package miscellaneous;

/**
 * Created by Deepankit on 10/2/2016.
 */
public class FooBarExampleWithTwoConditionalOperationAndSinglePrintCall {

    public static final String FOO = "foo";
    public static final String BAR = "bar";
    public static final String SPACE = " ";
    public static final String EMPTY = "";

    public static void main(String[] args) {
        int input = 20;
        printFooBar(input);
    }

    private static void printFooBar(int input) {
        String solution = EMPTY;
        String temp;
        for (int index = 1; index <= input; index++) {
            temp = index + EMPTY;
            if (index % 3 == 0)
                temp = FOO;
            if (index % 5 == 0)
                try {
                    Integer.valueOf(temp);
                    temp = BAR;
                } catch (NumberFormatException exception) {
                    temp = temp + BAR;
                }
            solution = solution + temp + SPACE;
        }
        System.out.println(solution);
    }
}
