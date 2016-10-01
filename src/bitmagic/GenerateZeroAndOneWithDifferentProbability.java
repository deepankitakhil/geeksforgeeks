package bitmagic;

import java.util.Random;

/**
 * Created by Deepankit on 9/24/2016.
 */
public class GenerateZeroAndOneWithDifferentProbability {
    public static void main(String[] args) {
        GenerateZeroAndOneWithDifferentProbability generateZeroAndOneWithDifferentProbability = new GenerateZeroAndOneWithDifferentProbability();
        generateZeroAndOneWithDifferentProbability.generateWith5050Probability();
        generateZeroAndOneWithDifferentProbability.generateWith7525Probability();
        generateZeroAndOneWithDifferentProbability.generateWith2575Probability();
    }

    private static int randomNumberGeneratorUtil() {
        Random random = new Random();
        int randomInteger = random.nextInt(2);
        return randomInteger;
    }

    private void generateWith2575Probability() {
        System.out.println(randomNumberGeneratorUtil() & randomNumberGeneratorUtil());
    }

    private void generateWith7525Probability() {
        System.out.println(randomNumberGeneratorUtil() | randomNumberGeneratorUtil());
    }

    private void generateWith5050Probability() {
        int generatedRandomNumber = randomNumberGeneratorUtil();
        System.out.println(generatedRandomNumber);

    }
}
