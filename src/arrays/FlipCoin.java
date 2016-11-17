package arrays;

/**
 * Created by Deepankit on 11/15/2016.
 */
public class FlipCoin {

  public static void main(String[] args) {
    int[] input = {1, 1, 0, 1, 0, 0, 1, 1};
    System.out.println(new FlipCoin().solution(input));
  }

  public int solution(int[] input) {
    boolean flipped = false;
    int adjacency = 0;
    for (int i = 1; i < input.length - 1; i++) {
      if (input[i] == input[i - 1])
        adjacency++;
      else if (input[i - 1] == input[i + 1] && !flipped) {
        flipped = true;
        adjacency += 2;
        i++;
      }
    }

    if (flipped) {
      if (input[input.length - 1] == input[input.length - 2]) adjacency++;
    } else {
      if (input[input.length - 1] != input[input.length - 2]) adjacency++;
      else if (input[0] != input[1]) adjacency += 2;
    }

    return adjacency;
  }
}
