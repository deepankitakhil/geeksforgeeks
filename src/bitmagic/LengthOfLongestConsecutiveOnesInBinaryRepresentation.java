package bitmagic;

/**
 * Created by Deepankit on 11/15/2016.
 */
public class LengthOfLongestConsecutiveOnesInBinaryRepresentation {
  public static void main(String[] args) {
    LengthOfLongestConsecutiveOnesInBinaryRepresentation lengthOfLongestConsecutiveOnesInBinaryRepresentation = new LengthOfLongestConsecutiveOnesInBinaryRepresentation();
    System.out.println(lengthOfLongestConsecutiveOnesInBinaryRepresentation.findMaxConsecutiveOnesLength(31));
  }

  private int findMaxConsecutiveOnesLength(int input) {
    int count = 0;
    int maxConsecutiveOnes = 0;
    while (input > 0) {
      if ((input & 1) == 1)
        count++;
      else count = 0;

      maxConsecutiveOnes = count > maxConsecutiveOnes ? count : maxConsecutiveOnes;
      input = input >> 1;
    }
    return maxConsecutiveOnes;
  }
}
