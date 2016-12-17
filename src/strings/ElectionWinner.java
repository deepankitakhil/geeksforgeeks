package strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by deepankit on 12/9/2016.
 */
public class ElectionWinner {

  public static void main(String[] args) {
    ElectionWinner electionWinner = new ElectionWinner();
    System.out.println(electionWinner.electionWinner(new String[]{"al", "mi", "ha", "da", "mi", "vi", "ha", "al", "ma", "ma"}));
  }

  private String electionWinner(String[] votes) {
    Map<String, Integer> candidateCount = new HashMap<>();
    Map<String, Integer> result = new LinkedHashMap<>();
    for (String input : votes) {
      if (candidateCount.containsKey(input))
        candidateCount.put(input, candidateCount.get(input) + 1);
      else
        candidateCount.put(input, 1);
    }

    candidateCount.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

    Iterator<Map.Entry<String, Integer>> iterator = result.entrySet().iterator();
    int maxVote = 0;
    String winner = "";
    while (iterator.hasNext()) {
      Map.Entry<String, Integer> next = iterator.next();
      String name = next.getKey();
      Integer value = next.getValue();
      if (maxVote <= value) {
        if (winner.compareTo(name) < 0) {
          winner = name;
          maxVote = value;
        }
      } else
        break;
    }
    return winner;

  }
}
