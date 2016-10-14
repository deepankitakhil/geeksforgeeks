package arrays;

/**
 * Created by Deepankit on 10/13/2016.
 */
public class MinEnergyRequiredtoCrossStreet {
    public static void main(String[] args) throws Exception {
        MinEnergyRequiredtoCrossStreet minEnergyRequiredtoCrossStreet = new MinEnergyRequiredtoCrossStreet();
        int[] input = new int[]{-1, -5, -9};
        minEnergyRequiredtoCrossStreet.validate(input);
        System.out.println(minEnergyRequiredtoCrossStreet.findMinEnergy(input));
    }

    private int findMinEnergy(int[] input) {
        int energyReceived = 0;
        int upthrust = 0;
        for (int index = 0; index < input.length; index++) {
            energyReceived += input[index];
            if (energyReceived < 0) {
                upthrust += -energyReceived;
                energyReceived = 0;
            }
        }
        return upthrust + 1;
    }

    private void validate(int[] input) throws Exception {
        if (input == null || input.length == 0)
            throw new Exception("invalid input");
    }
}
