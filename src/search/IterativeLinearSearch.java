package search;

/**
 * Created by Deepankit on 8/20/2016.
 */
public class IterativeLinearSearch {

    public static void main(String[] args) {
        IterativeLinearSearch iterativeLinearSearch = new IterativeLinearSearch();
        System.out.println(iterativeLinearSearch.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 10));
    }

    public int search(int[] input, int searchElement) {
        for (int index = 0; index < input.length; index++)
            if (input[index] == searchElement)
                return index;

        return -999;
    }
}
