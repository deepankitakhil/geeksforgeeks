package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by deepankit on 12/12/2016.
 */
public class FindUserNameInTweet {

  public static void main(String[] args) {
    FindUserNameInTweet findUserNameInTweet = new FindUserNameInTweet();
    String tweetString = "Ok folks! Non BJP, non Cong front to be \"\n" +
        "\t\t\t\t+ \"Deepankit Shukla and Swati Kanchan officially 'formed' today. The fun has only just begun! \"\n" +
        "\t\t\t\t+ \"A long summer lies ahead! Time to work! Bye\"";
    List<String> userNames = findUserNameInTweet.loadUserNames();
    List<String> userName = findUserNameInTweet.findUserName(tweetString, userNames);
    findUserNameInTweet.display(userName);
  }

  private void display(List<String> userName) {
    for (String name : userName)
      System.out.println(name);
  }

  private List<String> loadUserNames() {
    ArrayList<String> userNames = new ArrayList<>();
    userNames.add("Deepankit Shukla");
    userNames.add("Swati Kanchan");
    return userNames;
  }

  private List<String> findUserName(String tweetString, List<String> userNames) {
    List<String> output = new ArrayList<>();

    for (String userName : userNames) {
      Pattern pattern = Pattern.compile(".*" + userName + ".*");
      if (tweetString.contains(userName)) {
        output.add(userName);
      }
    }
    return output;
  }
}
