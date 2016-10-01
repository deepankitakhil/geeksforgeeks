package search;

/**
 * Created by Deepankit on 8/30/2016.
 */
public class FrequencyOfEachElementByIndexJumping {

    public static void main(String[] args) {
        FrequencyOfEachElementByIndexJumping frequencyOfEachElementByIndexJumping = new FrequencyOfEachElementByIndexJumping();
        frequencyOfEachElementByIndexJumping.findFrequency(new int[]{1, 1, 1, 2, 3, 3, 5,
                5, 8, 8, 8, 9, 9, 10});
    }

    private void findFrequency(int[] input) {
        int start = -1;
        int index = 0;
        while (index < input.length - 2) {
            if (input[index] == input[index + 2])
                index += 2;
            else if (input[index] == input[index + 1])
                index += 1;
            else {
                System.out.println(input[index] + " occurs " + (index - start) + " times");
                start = index;
                index++;

            }

        }
        System.out.println(input[index] + " occurs " + (index - start) + " times");
        if (index + 1 == input.length - 1)
            System.out.println(input[index + 1] + " occurs " + 1 + " times");

    }
}
