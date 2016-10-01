package search;

/**
 * Created by Deepankit on 8/29/2016.
 */
public class PairWithMaxProduct {

    public static final String SEPARATOR = " and ";

    public static void main(String[] args) {
        PairWithMaxProduct pairWithMaxProduct = new PairWithMaxProduct();
        System.out.println(pairWithMaxProduct.findMaxProduct(new int[]{1, 4, 3, 6, 7, 0}));

    }

    private String findMaxProduct(int[] input) {
        int firstBiggestPositiveInteger = Integer.MIN_VALUE;
        int secondBiggestPositiveInteger = Integer.MIN_VALUE;
        int firstBiggestNegativeInteger = Integer.MIN_VALUE;
        int secondBiggestNegativeInteger = Integer.MIN_VALUE;
        if (input.length > 0) {
            for (int index = 0; index < input.length; index++) {
                if (input[index] != 0) {
                    if (input[index] > 0 && input[index] > firstBiggestPositiveInteger) {
                        secondBiggestPositiveInteger = firstBiggestPositiveInteger;
                        firstBiggestPositiveInteger = input[index];
                    } else {
                        secondBiggestNegativeInteger = firstBiggestNegativeInteger;
                        firstBiggestNegativeInteger = input[index];
                    }
                }
            }
            if (firstBiggestNegativeInteger * secondBiggestNegativeInteger > firstBiggestPositiveInteger * secondBiggestPositiveInteger)
                return firstBiggestNegativeInteger + SEPARATOR + secondBiggestNegativeInteger;
            else
                return firstBiggestPositiveInteger + SEPARATOR + secondBiggestPositiveInteger;
        }
        return null;

    }
}
