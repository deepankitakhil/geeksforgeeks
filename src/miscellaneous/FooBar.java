package miscellaneous;

/**
 * Created by Deepankit on 10/2/2016.
 */
public class FooBar {

    private static final String FOO = "foo";
    private static final String BAR = "bar";
    private static final String EMPTY_STRING = "";

    public static void main(String[] args) {
        FooBar fooBar = new FooBar();
        int input = 100;
        fooBar.print(input);
    }

    private void print(int input) {
        StringBuilder builder = new StringBuilder();
        for (int index = 1; index <= input; index++) {
            String temp = "";
            if (index % 3 == 0)
                temp = temp.concat(FOO);
            if (index % 5 == 0)
                temp = temp.concat(BAR);
            if (temp == "")
                temp = temp.concat(EMPTY_STRING + index);
            builder.append(temp);
        }
        System.out.println(builder.toString());
    }
}
