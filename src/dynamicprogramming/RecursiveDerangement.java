package dynamicprogramming;

/**
 * Created by Deepankit on 10/11/2016.
 */
public class RecursiveDerangement {
    public static void main(String[] args) {
        RecursiveDerangement derangement = new RecursiveDerangement();
        int input = 6;
        System.out.println(derangement.countDerangement(input));
    }

    private int countDerangement(int input) {
        if (input == 0) return 1;
        else if (input == 1) return 0;
        else if (input == 2) return 1;
        else {
            int[] derangement = new int[input + 1];
            derangement[0] = 1;
            derangement[1] = 0;
            derangement[2] = 1;
            derangement[input] = (input - 1) * (countDerangement(input - 1) + countDerangement(input - 2));

            return derangement[input];
        }
    }
}
